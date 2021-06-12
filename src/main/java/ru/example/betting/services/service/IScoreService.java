package ru.example.betting.services.service;

import ru.example.betting.data.model.Score;

import java.util.List;

/**
 * Интерфейс для сервиса счета.
 *
 * @author Николай Евсюков
 */
public interface IScoreService {

    /**
     * Вернуть список всех счетов.
     *
     * @return список всех счетов
     */
    List<Score> getScores();
}
