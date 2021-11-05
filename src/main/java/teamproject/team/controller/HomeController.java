package teamproject.team.controller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import teamproject.team.service.ApiService;
import teamproject.team.service.BoardService;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final ApiService apiService;
    private final BoardService boardService;

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
}
