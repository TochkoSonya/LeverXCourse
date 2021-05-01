package Tochko.LeverXCourse.controllers;
import Tochko.LeverXCourse.models.Role;
import Tochko.LeverXCourse.models.User;
import Tochko.LeverXCourse.service.CommentService;
import Tochko.LeverXCourse.service.TraderService;
import Tochko.LeverXCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private TraderService traderService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/")
    public String listTrader(Model model) {
        model.addAttribute("listTrader", traderService.findTraderWithActiveStatus());
        return "main-view";
    }

    @RequestMapping(value="/authorization", method= RequestMethod.GET)
    public String userAuthorizationForm() {
        return "authorization-view";
    }


    @RequestMapping(value="/authorization", method= RequestMethod.POST)
    public String userAuthorization(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        User user = userService.findByEmailAndPassword(email, password);

        if(user ==null) {
            return "redirect:/";
        }
        if(user.getRole().equals(Role.ADMIN.getCode())) {
            return "redirect:/admin";
        }
        if(user.getRole().equals(Role.TRADER.getCode())){
            String path="redirect:/user/"+user.getUserId();
            return path;
        }
        else {
            return "redirect:/";
        }
    }

    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public String showAdminPage(Model model) {
        model.addAttribute("listTrader", traderService.listAll());
        model.addAttribute("listComment", commentService.listAll());
        return "admin-view";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST)
    public String redirectUpdate(Model model) {
        model.addAttribute("listTrader", traderService.listAll());
        model.addAttribute("listComment", commentService.listAll());
        return "admin-view";
    }



}