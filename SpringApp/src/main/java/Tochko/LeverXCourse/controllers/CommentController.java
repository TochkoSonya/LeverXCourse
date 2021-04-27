package Tochko.LeverXCourse.controllers;

import Tochko.LeverXCourse.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/list")
    public String listComments(Model model) {
        model.addAttribute("listComment", commentService.listAll());
        return "comment-view";
    }
}
