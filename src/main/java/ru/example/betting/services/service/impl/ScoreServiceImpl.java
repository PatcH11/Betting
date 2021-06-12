package ru.example.betting.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.betting.data.model.Score;
import ru.example.betting.data.repository.ScoreRepository;
import ru.example.betting.services.service.IScoreService;

import java.util.List;

/**
 * Реализация интерфейса IScoreService.
 *
 * @author Николай Евсюков
 */
@Service
public class ScoreServiceImpl implements IScoreService {

    /**
     * Репозиторий для счетов.
     */
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<Score> getScores() {
        return scoreRepository.findAll();
    }
}
