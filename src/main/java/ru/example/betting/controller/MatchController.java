package ru.example.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.example.betting.data.model.Bet;
import ru.example.betting.data.model.Match;
import ru.example.betting.services.service.IMatchService;
import ru.example.betting.services.service.IUserService;

import java.util.List;

@Controller
public class MatchController {

    private final IMatchService matchService;
    private final IUserService userService;

    @Autowired
    public MatchController(IMatchService matchService,
                           IUserService userService) {
        this.matchService = matchService;
        this.userService = userService;
    }

    @GetMapping("/matches")
    public String matches(Model model,
                          Authentication authentication){
        List<Match> matches = matchService.getMatches();

        model.addAttribute("matches", matches);
        model.addAttribute("user", userService.findByUsername(authentication.getName()));
        model.addAttribute("bet", new Bet());

        return "matches";
    }
}
