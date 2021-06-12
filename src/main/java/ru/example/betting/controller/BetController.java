package ru.example.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.example.betting.data.model.Bet;
import ru.example.betting.data.model.Picture;
import ru.example.betting.data.model.User;
import ru.example.betting.services.service.IBetService;
import ru.example.betting.services.service.IMatchService;
import ru.example.betting.services.service.IScoreService;
import ru.example.betting.services.service.ITeamService;
import ru.example.betting.services.service.IUserService;
import ru.example.betting.utils.Checks;
import ru.example.betting.utils.ImageUtil;

import java.util.List;

/**
 * Контроллер для ставок.
 *
 * @author Николай Евсюков
 */
@Controller
public class BetController {

    /**
     * Сервис для ставок.
     */
    private final IBetService betService;

    /**
     * Сервис для пользователя.
     */
    private final IUserService userService;

    /**
     * Сервис для матчей.
     */
    private final IMatchService matchService;

    /**
     * Сервис для команд.
     */
    private final ITeamService teamService;

    /**
     * Сервис для счета.
     */
    private final IScoreService scoreService;

    @Autowired
    public BetController(IBetService betService,
                         IUserService userService,
                         IMatchService matchService,
                         ITeamService teamService,
                         IScoreService scoreService) {
        this.betService = betService;
        this.userService = userService;
        this.matchService = matchService;
        this.teamService = teamService;
        this.scoreService = scoreService;
    }

    /**
     * Сделать ставку на команду.
     *
     * @param id             ID команды, на которую происходит ставка
     * @param authentication данные об авторизированном пользователе
     * @return страницу bets
     */
    @GetMapping("/bet/{id}")
    public String addBet(@PathVariable("id") int id,
                         Authentication authentication) {
        if (!scoreService.getScores().isEmpty()) {
            scoreService.getScores();
            return "redirect:/errorBet";
        }

        Bet bet = new Bet();
        bet.setUser(userService.findByUsername(authentication.getName()));
        bet.setMatch(matchService.findByHomeIdOrAwayId(id, id));
        bet.setWinner(teamService.findById(id));

        betService.create(bet);


        return "redirect:/bets";
    }


    /**
     * Отображение страницы bets.
     *
     * @param model          модель
     * @param authentication данные об авторизированном пользователе
     * @return страницу bets
     */
    @GetMapping("/bets")
    public String bets(Model model,
                       Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());

        Picture picture = user.getPicture();
        List<Bet> bets = betService.getAllByUserUsername(user.getUsername());

        model.addAttribute("betCheck", new Checks());
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("picture", picture);
        model.addAttribute("bets", bets);

        return "bets";
    }

    /**
     * Отображение страницы errorBet.
     *
     * @return страница с ошибкой ставки
     */
    @GetMapping("/errorBet")
    public String errorBet() {
        return "errorBet";
    }
}
