package ru.example.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.example.betting.commons.ImageUtil;
import ru.example.betting.data.model.Bet;
import ru.example.betting.data.model.Picture;
import ru.example.betting.data.model.User;
import ru.example.betting.services.service.IBetService;
import ru.example.betting.services.service.IMatchService;
import ru.example.betting.services.service.ITeamService;
import ru.example.betting.services.service.IUserService;

import java.util.List;

@Controller
public class BetController {

    private final IBetService betService;
    private final IUserService userService;
    private final IMatchService matchService;
    private final ITeamService teamService;

    @Autowired
    public BetController(IBetService betService,
                         IUserService userService,
                         IMatchService matchService,
                         ITeamService teamService) {
        this.betService = betService;
        this.userService = userService;
        this.matchService = matchService;
        this.teamService = teamService;
    }

    @GetMapping("/bet/{id}")
    public String addBet(@PathVariable("id") int id,
                         Authentication authentication){
        Bet bet = new Bet();
        bet.setUser(userService.findByUsername(authentication.getName()));
        bet.setMatch(matchService.findByHomeIdOrAwayId(id, id));
        bet.setWinner(teamService.findById(id));

        betService.create(bet);

        return "redirect:/bets";
    }


    @GetMapping(value = "/bets")
    public String bets(Model model,
                       Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());

        Picture picture = user.getPicture();
        List<Bet> bets = betService.getAllByUserUsername(user.getUsername());

        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("picture", picture);
        model.addAttribute("bets", bets);

        return "bets";
    }
}
