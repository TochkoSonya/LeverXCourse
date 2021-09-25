package leverXCourse.service;

import leverXCourse.models.Comment;
import leverXCourse.models.Trader;
import leverXCourse.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class CommentService implements CommonService<Comment>{

    @Autowired
    private CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment get(Integer commentId) { return commentRepository.findOne(commentId);}

    public void delete(int id) {commentRepository.delete(id);}

    public List<Comment> listAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findByTrader(Trader trader) { return commentRepository.findByTrader(trader); }

    public List<Comment> findCommentsWithActiveStatusByTrader(Trader trader) {
        return commentRepository.findCommentsWithActiveStatusByTrader(trader);
    }
}


