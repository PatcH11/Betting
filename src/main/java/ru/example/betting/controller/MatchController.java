package ru.example.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.example.betting.data.model.Bet;
import ru.example.betting.data.model.Match;
import ru.example.betting.services.service.IMatchService;
import ru.example.betting.services.service.IScoreService;
import ru.example.betting.services.service.IUserService;
import ru.example.betting.utils.Checks;

import java.util.List;

/**
 * Контроллер для матчей.
 *
 * @author Николай Евсюков
 */
@Controller
public class MatchController {

    /**
     * Сервис для матчей.
     */
    private final IMatchService matchService;

    /**
     * Сервис для пользователей.
     */
    private final IUserService userService;

    /**
     * Сервис для счета.
     */
    private final IScoreService scoreService;

    @Autowired
    public MatchController(IMatchService matchService,
                           IUserService userService,
                           IScoreService scoreService) {
        this.matchService = matchService;
        this.userService = userService;
        this.scoreService = scoreService;
    }

    /**
     * Отображение страницы matches.
     *
     * @param model          модель
     * @param authentication данные об авторизированном пользователе
     * @return страницу
     */
    @GetMapping("/matches")
    public String matches(Model model,
                          Authentication authentication) {
        List<Match> matches = matchService.getMatches();

        model.addAttribute("matches", matches);
        model.addAttribute("user", userService.findByUsername(authentication.getName()));
        model.addAttribute("bet", new Bet());
        model.addAttribute("betCheck", new Checks());

        return "matches";
    }

    /**
     * Провести все матчи.
     *
     * @return страницу об успешном проведении
     */
    @GetMapping(value = "/work")
    public String playMatches() {
        List<Match> matches = matchService.getMatches();

        if (scoreService.getScores().isEmpty() && scoreService.getScores() != null) {
            matchService.playMatches(matches);
            return "playMatches";
        }

        return "errorMatches";
    }

    /**
     * Отображение страницы об ошибке проведения матчей.
     *
     * @return страница с ошибкой
     */
    @GetMapping("/errorMatches")
    public String errorMatches() {
        return "errorMatches";
    }
}
