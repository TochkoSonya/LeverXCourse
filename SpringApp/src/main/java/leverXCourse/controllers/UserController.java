package leverXCourse.controllers;
import leverXCourse.models.Role;
import leverXCourse.models.Status;
import leverXCourse.models.Trader;
import leverXCourse.models.User;
import leverXCourse.service.CommentService;
import leverXCourse.service.TraderService;
import leverXCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TraderService traderService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/users", method=RequestMethod.GET)
    public String listUsers(@PathVariable("userId") int userId, Model model) {
        model.addAttribute("trader", traderService.listTraderByUserId(userId).get(0));
        model.addAttribute("listComment", commentService.findByTrader(traderService.listTraderByUserId(userId).get(0))) ;
        return "user-view";
    }

    @RequestMapping(value = "/registration", method=RequestMethod.GET)
    public String addUserForm(Model model) {
        return "createUser-view";
    }

    @RequestMapping(value = "/users", method=RequestMethod.POST)
    public String addUser(@RequestParam("title") String title, @RequestParam("description") String description,
                          @RequestParam("password") String password, User user) {
        user.setRole(Role.TRADER);
        user.setStatus(Status.PROCESSING);
        user.setPassword(password.hashCode());
        userService.save(user);
        Trader newTrader=new Trader();
        newTrader.setTitle(title);
        newTrader.setDescription(description);
        newTrader.setUser(user);
        traderService.save(newTrader);
        return "redirect:/";
    }

}
