package Tochko.LeverXCourse.controllers;

import Tochko.LeverXCourse.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/list")
    public String listGames(Model model) {
        model.addAttribute("listGame", gameService.listAll());
        return "game-view";
    }
}