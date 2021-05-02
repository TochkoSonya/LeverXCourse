package Tochko.LeverXCourse.controllers;
import Tochko.LeverXCourse.models.Comment;
import Tochko.LeverXCourse.models.Status;
import Tochko.LeverXCourse.service.CommentService;
import Tochko.LeverXCourse.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;


@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private TraderService traderService;

    @RequestMapping("/list")
    public String listComments(Model model) {
        model.addAttribute("listComment", commentService.listAll());
        return "comment-view";
    }

    @RequestMapping(value="/{traderId}/comments", method= RequestMethod.GET)
    public String listCommentsByTraderId(@PathVariable("traderId") int traderId, Model model) {
        model.addAttribute("listComments", commentService.findCommentsWithActiveStatusByTrader(traderService.get(traderId)));
        return "comment-view";
    }

    @RequestMapping(value="/{traderId}/comments", method= RequestMethod.POST)
    public String createComment(@PathVariable("traderId") int traderId, @RequestParam("message") String message, Model model, Comment comment) {
       comment.setMessage(message);
       comment.setTrader(traderService.get(traderId));
       comment.setCreatedDate(new Date());
       comment.setStatus(Status.PROCESSING);
       commentService.save(comment);
        return "redirect:/";
    }

    @RequestMapping(value="delete/{commentId}", method=RequestMethod.GET)
    public String deleteComment(@PathVariable("commentId") int commentId) {
        commentService.delete(commentId);
        return "redirect:/admin";
    }


    @RequestMapping(value="update/{commentId}", method=RequestMethod.POST)
    public String updateCommentStatus(@PathVariable("commentId") int commentId, @RequestParam("commentStatus") String commentStatus) {
        Status status =Status.ACTIVE.getCode().equals(commentStatus) ? Status.ACTIVE : Status.INACTIVE;
        Comment comment=commentService.get(commentId);
        comment.setStatus(status);
        commentService.save(comment);
        return "redirect:/admin";
    }




}
