package teamproject.team.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import teamproject.team.domain.Comment;
import teamproject.team.repository.CommentRepository;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getCommentList(String title) {
        return commentRepository.getCommentList(title);
    }

    public void insertComment(Comment comment) {
        commentRepository.insertComment(comment);
    }

    public void updateComment(long id, String title, String comment) {
        commentRepository.updateComment(id, title, comment);
    }

    public void deleteComment(long id) {
        commentRepository.deleteComment(id);
    }

    public Long getId(String name) {
        return commentRepository.getId(name);
    }
    public String getCommentPwCheck(String name, String pw) {
        return commentRepository.getCommentPwCheck(name, pw);
    }
}
