package Tochko.LeverXCourse.controllers;

import Tochko.LeverXCourse.models.*;
import Tochko.LeverXCourse.service.CommentService;
import Tochko.LeverXCourse.service.TraderService;
import Tochko.LeverXCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/trader")
public class TraderController {

    @Autowired
    private UserService userService;

    @Autowired
    private TraderService traderService;

    @Autowired
    private CommentService commentService;

//    @RequestMapping("/list")
//    public String listUsers(Model model) {
//        model.addAttribute("listUser", traderService.listAll());
//        return "user-view";
//    }

    @RequestMapping(value = "/registration", method=RequestMethod.GET)
    public String addTraderForm(Model model) {
        return "createTrader-view";
    }

    @RequestMapping(value = "/registration", method=RequestMethod.POST)
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

    @RequestMapping(value="updateStatus/{traderId}", method=RequestMethod.POST)
    public String updateTraderStatus(@PathVariable("traderId") int traderId, @RequestParam("traderStatus") String traderStatus) {
       Status status =Status.ACTIVE.getCode().equals(traderStatus) ? Status.ACTIVE : Status.INACTIVE;
       Trader trader= traderService.get(traderId);
        trader.getUser().setStatus(status);
        userService.save(trader.getUser());
        return "redirect:/admin";
    }

    @RequestMapping(value="delete/{traderId}", method = RequestMethod.GET)
    public String deleteTrader(@PathVariable("traderId") int traderId) {
        traderService.delete(traderId);
        return "redirect:/admin";
    }
    @RequestMapping(value="update/{traderId}", method = RequestMethod.POST)
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
