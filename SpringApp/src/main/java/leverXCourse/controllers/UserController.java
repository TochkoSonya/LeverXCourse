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
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final TraderService traderService;
    private final CommentService commentService;

    @Autowired
    public UserController(UserService userService,
                          TraderService traderService,
                          CommentService commentService) {
        this.userService = userService;
        this.traderService = traderService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(@PathVariable("userId") int userId, Model model) {
        model.addAttribute("trader", traderService.listTraderByUserId(userId).get(0));
        model.addAttribute("listComment", commentService.findByTrader(traderService.listTraderByUserId(userId).get(0)));
        return "user-view";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        return "createUser-view";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("password") String password,
                          @RequestBody User user) {
        userService.save(user, password);

        Trader newTrader = new Trader();
        newTrader.setUser(user);
        traderService.save(newTrader, title, description);
        return "redirect:/";
    }
}
