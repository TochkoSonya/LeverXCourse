package leverXCourse.controllers;
import leverXCourse.models.*;
import leverXCourse.service.CommentService;
import leverXCourse.service.TraderService;
import leverXCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

//TODO change all mappings (trader controller)

@Controller
@RequestMapping("/")
public class TraderController {

    @Autowired
    private UserService userService;

    @Autowired
    private TraderService traderService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/registration", method=RequestMethod.GET)
    public String addTraderForm(Model model) {
        return "createTrader-view";
    }

    @RequestMapping(value = "/traders", method=RequestMethod.POST)
    public String addTrader(@RequestParam("title") String title, @RequestParam("description") String description,
                            @RequestParam("message") String message, Trader trader) {

        trader.setTitle(title);
        trader.setDescription(description);
        trader.setUser(userService.get(9));
       traderService.save(trader);

        Comment newComment= new Comment();
        newComment.setTrader(trader);
        newComment.setMessage(message);
        newComment.setCreatedDate(new Date());
        newComment.setStatus(Status.PROCESSING);
        commentService.save(newComment);

        return "redirect:/";
    }

    @RequestMapping(value="/traders/{traderId}", method=RequestMethod.PUT)
    public String updateTraderStatus(@PathVariable("traderId") int traderId, @RequestParam("traderStatus") String traderStatus) {
       Status status =Status.ACTIVE.getCode().equals(traderStatus) ? Status.ACTIVE : Status.INACTIVE;
       Trader trader= traderService.get(traderId);
        trader.getUser().setStatus(status);
        userService.save(trader.getUser());
        return "redirect:/admin";
    }

    @RequestMapping(value="/traders/{traderId}", method = RequestMethod.DELETE)
    public String deleteTrader(@PathVariable("traderId") int traderId) {
        traderService.delete(traderId);
        return "redirect:/admin";
    }
    @RequestMapping(value="/traders/{traderId}", method = RequestMethod.PUT)
    public String updateTrader(@PathVariable("traderId") int traderId, @RequestParam("title") String title,
                               @RequestParam("description") String description, @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName, @RequestParam("email") String email) {
        Trader trader=traderService.get(traderId);
        trader.setTitle(title);
        trader.setDescription(description);
        trader.getUser().setFirstName(firstName);
        trader.getUser().setLastName(lastName);
        trader.getUser().setEmail(email);
        traderService.save(trader);
        String path="redirect:/user/" + trader.getUser().getUserId();
       return path;
    }
}
