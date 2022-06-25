package leverXCourse.controllers;

import leverXCourse.models.*;
import leverXCourse.service.impl.CommentServiceImpl;
import leverXCourse.service.impl.TraderServiceImpl;
import leverXCourse.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TraderController {

    private final UserServiceImpl userService;
    private final TraderServiceImpl traderService;
    private final CommentServiceImpl commentService;

    @Autowired
    public TraderController(UserServiceImpl userService,
                            TraderServiceImpl traderService,
                            CommentServiceImpl commentService) {
        this.userService = userService;
        this.traderService = traderService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String addTraderForm(Model model) {
        return "createTrader-view";
    }

    @RequestMapping(value = "/traders", method = RequestMethod.POST)
    public String addTrader(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("message") String message,
                            Trader trader) {
        traderService.save(trader, title, description);

        Comment newComment = new Comment();
        commentService.save(newComment, trader.getTraderId(), message);
        return "redirect:/";
    }

    @RequestMapping(value = "/traders/{traderId}", method = RequestMethod.PUT)
    public String updateTraderStatus(@PathVariable("traderId") int traderId,
                                     @RequestParam("traderStatus") String traderStatus) {
        Status status = Status.ACTIVE.getCode().equals(traderStatus) ? Status.ACTIVE : Status.INACTIVE;
        Trader trader = traderService.get(traderId);
        trader.getUser().setStatus(status);
        userService.save(trader.getUser());
        return "redirect:/admin";
    }

    @RequestMapping(value = "/traders/{traderId}", method = RequestMethod.DELETE)
    public String deleteTrader(@PathVariable("traderId") int traderId) {
        traderService.delete(traderId);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/traders/{traderId}", method = RequestMethod.PUT)
    public String updateTrader(@RequestBody Trader trader) {
        traderService.save(trader);
        String path = "redirect:/user/" + trader.getUser().getUserId();
        return path;
    }
}
