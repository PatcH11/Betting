package ru.example.betting.services.service;

import ru.example.betting.data.model.Bet;

import java.util.List;

/**
 * Интерфейс для сервиса ставок.
 *
 * @author Николай  Евсюков
 */
public interface IBetService {

    /**
     * Создание ставки.
     *
     * @param bet ставка
     * @return сделанная ставка
     */
    Bet create(Bet bet);

    /**
     * Возвращение списка ставок по username пользователя.
     *
     * @param username ник пользователя
     * @return список ставок
     */
    List<Bet> getAllByUserUsername(String username);
}
