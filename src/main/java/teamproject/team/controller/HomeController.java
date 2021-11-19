package teamproject.team.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import teamproject.team.domain.Board;
import teamproject.team.domain.Comment;
import teamproject.team.domain.Member;
import teamproject.team.domain.Recommended;
import teamproject.team.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ApiService apiService;
    private final BoardService boardService;
    private final MemberService memberService;
    private final CommentService commentService;
    private final RecommendedService recommendedService;

    @GetMapping("/")
    public String home(Model model) {
        apiService.test();
        List list = boardService.getList();
        List firstRank = boardService.getFirstRank();
        model.addAttribute("list", list);
        model.addAttribute("firstRank", firstRank);
        return "index";
    }

    @GetMapping("/week")
    public String weekRank(Model model) {
        apiService.test();
        List list = boardService.getList2();
        List firstRank = boardService.getFirstRank2();
        model.addAttribute("list", list);
        model.addAttribute("firstRank", firstRank);
        return "index";
    }

    @GetMapping("/drama")
    public String dramaRank(Model model) {
        apiService.test();
        List list = boardService.getList3();
        List firstRank = boardService.getFirstRank3();
        model.addAttribute("list", list);
        model.addAttribute("firstRank", firstRank);
        return "index";
    }

    @GetMapping("/review")
    public String review(Model model) {
        List list = boardService.totalList();
        model.addAttribute("list", list);
        return "reviewHome";
    }

    @GetMapping("/review/{title}")
    public String review(@PathVariable String title, Model model) {
        List list = boardService.totalDetail(title);
        List comment = commentService.getCommentList(title);
        model.addAttribute("list", list);
        model.addAttribute("comment", comment);
        return "review";
    }

    @PostMapping("/insertComment")
    public String insertComment(HttpServletRequest request) {
        Comment comment = new Comment();
        comment.setName(request.getParameter("name"));
        comment.setPw(request.getParameter("pw"));
        comment.setComment(request.getParameter("comment"));
        comment.setTitle(request.getParameter("title"));
        commentService.insertComment(comment);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/check")
    public String check(HttpServletRequest request, Model model) {
        try {
            String name = request.getParameter("name");
            String title = request.getParameter("title");
            String way = request.getParameter("way");
            String no = request.getParameter("no");
            String encodedParam = URLEncoder.encode(title, "UTF-8");
            String catchPw = commentService.getCommentPwCheck(name);
            String tryPw = request.getParameter("pw");
            Long getId = commentService.getId(name);
            if (catchPw.equals(tryPw)) {
                if (way.equals("update")) {
                    model.addAttribute("name", name);
                    model.addAttribute("title", title);
                    model.addAttribute("no", no);

                    return "/commentUpdate";
                    //commentService.updateComment(getId, title);
                }
                else commentService.deleteComment(getId);
                return "redirect:/review/" + encodedParam;
            } else {
                return "errors";
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return "/";
    }

    @PostMapping("/join")
    public String postJoin(HttpServletRequest request) {
        Member member = new Member();
        // 중복 아이디 검증하는 것이 필요하다.
        member.setLoginame(request.getParameter("loginame"));
        member.setName(request.getParameter("name"));
        member.setPw(request.getParameter("pw"));
        memberService.joinUs(member);
        return "redirect:/";
    }

    @GetMapping("/commentUpdate")
    public String commentUpdate(HttpServletRequest request) {
        try {
            String title = request.getParameter("title");
            String comment = request.getParameter("comment");
            long id = Long.parseLong(request.getParameter("no"));
            String encodedParam = URLEncoder.encode(title, "UTF-8");
            commentService.updateComment(id, title, comment);
            return "redirect:/review/" + encodedParam;
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
        return "/";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String title = request.getParameter("title");
        String update = request.getParameter("update");
        String insert = request.getParameter("insert");
        model.addAttribute("title", title);
        if (update != null) {
            model.addAttribute("update", update);
        } else if (insert != null) {
            model.addAttribute("insert", insert);
        }
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, Model model) {
        try {
            String name = request.getParameter("name");
            String pw = request.getParameter("passwd");
            String title = request.getParameter("title");
            String update = request.getParameter("update");
            String insert = request.getParameter("insert");
            String encodedParam = URLEncoder.encode(title, "UTF-8");
            if (update.equals("update") && name.equals("root") && pw.equals("12345")) {
                model.addAttribute("title", title);
                return "update";
            } else if (insert.equals("insert") && name.equals("root") && pw.equals("12345")) {
                return "insert";
            } else {
                Member member = new Member();
                member.setLoginame(name);
                member.setPw(pw);
                Member a = memberService.login(member);

                if (a != null) {
                    Recommended recommended = new Recommended();
                    recommended.setLoginame(name);
                    recommended.setTitle(title);
                    Recommended check = recommendedService.findRecommended(recommended);
                    if (check != null) {
                        model.addAttribute("errors", "이미 추천을 누르셨습니다.");
                        return "/errors";
                    } else {
                        boardService.rankCnt(title);
                        recommendedService.insertRecommended(recommended);
                    }
                    return "redirect:/review/" + encodedParam;
                } else {
                    model.addAttribute("errors", "비밀번호가 다릅니다.");
                    return "errors";
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return "/";
    }

    @GetMapping("/check/{name}/{title}")
    public String check(@PathVariable String title,
                        @PathVariable String name,
                        Model model, HttpServletRequest request) {
        String way = request.getParameter("way");
        String no = request.getParameter("no");
        model.addAttribute("title", title);
        model.addAttribute("name", name);
        model.addAttribute("way", way);
        model.addAttribute("no", no);

        return "check";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request) {
        try {
            Board board = new Board();
            String title = request.getParameter("title");
            System.out.println("업데이트 넘어온 이후에 " + title);
            board.setTitle(title);
            board.setContent(request.getParameter("content"));
            boardService.totalUpdateContent(board);
            String encodedParam = URLEncoder.encode(title, "UTF-8");
            return "redirect:/review/" + encodedParam;
        } catch (Exception e) {
            System.out.println("exception");
        }
        return "/";
    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request) {
        Board board = new Board();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setRanks(0);
        boardService.totalInsert(board);
        return "redirect:/review";
    }
}
