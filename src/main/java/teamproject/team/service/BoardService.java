package teamproject.team.service;

import lombok.AllArgsConstructor;
import teamproject.team.domain.Board;
import teamproject.team.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    public List<Board> getList() {
        return repository.getList();
    }
    public List<Board> getFirstRank() {
        return repository.getFirstRank();
    }
    public void boardInsert(Board board) {
        repository.boardInsert(board);
    }
    public void boardDelete() {
        repository.deleteContent();
    }
    public List<Board> getList2() {
        return repository.getList2();
    }
    public void boardInsert2(Board board) {
        repository.boardInsert2(board);
    }
    public List<Board> getFirstRank2() {
        return repository.getFirstRank2();
    }
    public void boardDelete2() {
        repository.deleteContent2();
    }
    public List<Board> getList3() {
        return repository.getList3();
    }
    public List<Board> getFirstRank3() {
        return repository.getFirstRank3();
    }
    public void boardInsert3(Board board) {
        repository.boardInsert3(board);
    }
    public void boardDelete3() {
        repository.deleteContent3();
    }

    public void totalInsert(Board board) {repository.totalInsert(board);}
    public List<Board> totalList() { return repository.totalList(); }

    public List<Board> totalDetail(String title) {
        return repository.totalDetail(title);
    }
    public void rankCnt(String title) {
        repository.rankCnt(title);
    }

    public void totalUpdateContent(Board board) { repository.totalUpdateContent(board);}
}
