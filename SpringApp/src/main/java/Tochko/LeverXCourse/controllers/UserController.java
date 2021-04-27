package Tochko.LeverXCourse.controllers;

import Tochko.LeverXCourse.service.TraderService;
import Tochko.LeverXCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TraderService traderService;

    @RequestMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("listUser", traderService.listAll());
        return "user-view";
    }
}
