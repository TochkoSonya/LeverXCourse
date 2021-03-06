package leverXCourse.controllers;

import leverXCourse.models.Role;
import leverXCourse.models.User;
import leverXCourse.service.CommentService;
import leverXCourse.service.TraderService;
import leverXCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    private final UserService userService;
    private final TraderService traderService;
    private final CommentService commentService;

    @Autowired
    public MainController(UserService userService,
                          TraderService traderService,
                          CommentService commentService) {
        this.userService = userService;
        this.traderService = traderService;
        this.commentService = commentService;
    }

    @RequestMapping("/")
    public String listTrader(Model model) {
        model.addAttribute("listTrader", traderService.findTraderWithActiveStatus());
        return "main-view";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String userAuthorizationForm() {
        return "authorization-view";
    }


    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public String userAuthorization(@RequestParam("email") String email,
                                    @RequestParam("password") String password,
                                    Model model) {
        User user = userService.findByEmailAndPassword(email, password.hashCode());

        if (user == null) {
            return "redirect:/";
        }
        if (user.getRole().equals(Role.ADMIN.getCode())) {
            return "redirect:/admin";
        }
        if (user.getRole().equals(Role.TRADER.getCode())) {
            String path = "redirect:/users/" + user.getUserId();
            return path;
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showAdminPage(Model model) {
        model.addAttribute("listTrader", traderService.listAll());
        model.addAttribute("listComment", commentService.listAll());
        return "admin-view";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String redirectUpdate(Model model) {
        model.addAttribute("listTrader", traderService.listAll());
        model.addAttribute("listComment", commentService.listAll());
        return "admin-view";
    }
}
