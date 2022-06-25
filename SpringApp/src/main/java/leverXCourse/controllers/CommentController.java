package leverXCourse.controllers;

import leverXCourse.models.Comment;
import leverXCourse.models.Status;
import leverXCourse.service.CommentService;
import leverXCourse.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CommentController {

    private final CommentService commentService;
    private final TraderService traderService;

    @Autowired
    public CommentController(CommentService commentService,
                             TraderService traderService) {
        this.commentService = commentService;
        this.traderService = traderService;
    }

    @RequestMapping(value = "/traders/{traderId}/comments", method = RequestMethod.GET)
    public String listComments(Model model) {
        model.addAttribute("listComment", commentService.listAll());
        return "comment-view";
    }

    @RequestMapping(value = "/traders/{traderId}/comments", method = RequestMethod.GET)
    public String listCommentsByTraderId(@PathVariable("traderId") int traderId, Model model) {
        model.addAttribute("listComments",
                commentService.findCommentsWithActiveStatusByTrader(traderService.get(traderId)));
        return "comment-view";
    }

    @RequestMapping(value = "/traders/{traderId}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable("traderId") int traderId,
                                @RequestParam("message") String message,
                                Model model,
                                Comment comment) {
        commentService.save(comment, traderId, message);
        return "redirect:/";
    }

    @RequestMapping(value = "/traders/{traderId}/comments/{commentId}", method = RequestMethod.DELETE)
    public String deleteComment(@PathVariable("commentId") int commentId) {
        commentService.delete(commentId);
        return "redirect:/admin";
    }


    @RequestMapping(value = "/traders/{traderId}/comments/{commentId}", method = RequestMethod.PUT)
    public String updateCommentStatus(@PathVariable("commentId") int commentId,
                                      @RequestParam("commentStatus") String commentStatus) {
        Status status = Status.ACTIVE.getCode().equals(commentStatus) ? Status.ACTIVE : Status.INACTIVE;
        commentService.updateStatus(commentId, status);
        return "redirect:/admin";
    }
}
