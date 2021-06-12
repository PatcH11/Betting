package ru.example.betting.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.betting.data.model.Match;
import ru.example.betting.data.model.Score;
import ru.example.betting.data.repository.MatchRepository;
import ru.example.betting.data.repository.ScoreRepository;
import ru.example.betting.services.service.IMatchService;
import ru.example.betting.utils.GeneratingNumbers;

import java.util.List;

/**
 * Реализация интерфейса IMatchService.
 *
 * @author Николай Евсюков
 */
@Service
public class MatchServiceImpl implements IMatchService {

    /**
     * Репозиторий для матчей.
     */
    private final MatchRepository matchRepository;

    /**
     * Репозиторий для счетов.
     */
    private final ScoreRepository scoreRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository,
                            ScoreRepository scoreRepository) {
        this.matchRepository = matchRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match findByHomeIdOrAwayId(int homeId, int awayId) {
        return matchRepository.findByHomeIdOrAwayId(homeId, awayId);
    }

    @Override
    @Transactional
    public void playMatches(List<Match> matches) {
        for (Match match : matches) {

            Score score = new Score();

            match.setScore(score);

            matchRepository.save(match);

            score.setHomeScore(GeneratingNumbers.rnd(5));
            score.setAwayScore(GeneratingNumbers.rnd(5));

            scoreRepository.save(score);
        }
    }
}
