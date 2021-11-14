package teamproject.team.repository;

import org.springframework.stereotype.Repository;
import teamproject.team.domain.Comment;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommentRepository {

    List<Comment> getCommentList(String title);
    void insertComment(Comment comment);
    void updateComment(long id, String title);
    void deleteComment(long id);
    String getCommentPwCheck(String name);
    Long getId(String name);

}
