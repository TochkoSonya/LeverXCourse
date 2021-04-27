package Tochko.LeverXCourse.service;

import Tochko.LeverXCourse.models.Comment;
import Tochko.LeverXCourse.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> listAll() {
        return commentRepository.findAll();
    }
}



