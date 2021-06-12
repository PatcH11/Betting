package ru.example.betting.utils;

import ru.example.betting.commons.BetStatus;
import ru.example.betting.data.model.Bet;
import ru.example.betting.data.model.Match;

/**
 * Проверка матчей.
 *
 * @author Николай Евсюков
 */
public class Checks {

    /**
     * Проверка статуса ставки.
     *
     * @param bet ставка пользователя
     * @return статус ставки
     */
    public BetStatus checkBets(Bet bet) {
        if (bet.getMatch().getScore() == null) {
            return BetStatus.IN_PROGRESS;
        } else if (bet.getMatch().getHome() == bet.getWinner()
                && bet.getMatch().getScore().getHomeScore() < bet.getMatch().getScore().getAwayScore()) {
            return BetStatus.LOSE;
        } else if (bet.getMatch().getAway() == bet.getWinner()
                && bet.getMatch().getScore().getHomeScore() > bet.getMatch().getScore().getAwayScore()) {
            return BetStatus.LOSE;
        } else if (bet.getMatch().getAway() == bet.getWinner()
                && bet.getMatch().getScore().getHomeScore() < bet.getMatch().getScore().getAwayScore()) {
            return BetStatus.WIN;
        } else if (bet.getMatch().getHome() == bet.getWinner()
                && bet.getMatch().getScore().getHomeScore() > bet.getMatch().getScore().getAwayScore()) {
            return BetStatus.WIN;
        }
        return BetStatus.DRAW;
    }

    /**
     * Проверка статуса матча.
     *
     * @param match матч для проверки
     * @return статус матча
     */
    public String checkMatches(Match match) {
        if (match.getScore() == null) {
            return "Coming Soon";
        }
        return match.getScore().toString();
    }
}
