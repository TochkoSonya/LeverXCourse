package leverXCourse.service.impl;

import leverXCourse.models.Comment;
import leverXCourse.models.Status;
import leverXCourse.models.Trader;
import leverXCourse.repository.CommentRepository;
import leverXCourse.service.CommentService;
import leverXCourse.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TraderService traderService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository,
                              TraderService traderService) {
        this.commentRepository = commentRepository;
        this.traderService = traderService;
    }

    @Override
    public void save(Comment comment, int traderId, String message) {
        comment.setMessage(message);
        comment.setTrader(traderService.get(traderId));
        comment.setCreatedDate(new Date());
        comment.setStatus(Status.PROCESSING);
        commentRepository.save(comment);
    }

    @Override
    public Comment get(Integer commentId) {
        return commentRepository.findOne(commentId);
    }

    @Override
    public void delete(int id) {
        commentRepository.delete(id);
    }

    @Override
    public List<Comment> listAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findByTrader(Trader trader) {
        return commentRepository.findByTrader(trader);
    }

    @Override
    public List<Comment> findCommentsWithActiveStatusByTrader(Trader trader) {
        return commentRepository.findCommentsWithActiveStatusByTrader(trader);
    }

    @Override
    public void updateStatus(int commentId, Status status) {
        Comment comment = get(commentId);
        comment.setStatus(status);
        commentRepository.save(comment);
    }
}



