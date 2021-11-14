package teamproject.team.repository;

import org.springframework.stereotype.Repository;
import teamproject.team.domain.Board;

import java.util.List;

@Repository
public interface BoardRepository {
    List<Board> getList();
    List<Board> getFirstRank();
    void boardInsert(Board board);
    void deleteContent();

    List<Board> getList2();
    List<Board> getFirstRank2();
    void boardInsert2(Board board);
    void deleteContent2();

    List<Board> getList3();
    List<Board> getFirstRank3();
    void boardInsert3(Board board);
    void deleteContent3();

    List<Board> totalList();
    void totalInsert(Board board);

    List<Board> totalDetail(String title);

    void rankCnt(String title);
    void totalUpdateContent(Board board);


}
