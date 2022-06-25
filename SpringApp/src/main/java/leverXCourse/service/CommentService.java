package leverXCourse.service;

import leverXCourse.models.Comment;
import leverXCourse.models.Status;
import leverXCourse.models.Trader;

import java.util.List;

public interface CommentService {

    void save(Comment comment, int traderId, String message);

    Comment get(Integer commentId);

    void delete(int id);

    List<Comment> listAll();

    List<Comment> findByTrader(Trader trader);

    List<Comment> findCommentsWithActiveStatusByTrader(Trader trader);

    void updateStatus(int commentId, Status status);
}
