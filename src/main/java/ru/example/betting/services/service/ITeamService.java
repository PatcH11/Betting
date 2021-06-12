package ru.example.betting.services.service;

import ru.example.betting.data.model.Team;

/**
 * Интерфейс для сервиса команды.
 *
 * @author Николай Евсюков
 */
public interface ITeamService {

    /**
     * Поиск команды по ее ID.
     *
     * @param id ID команды
     * @return найденная команда
     */
    Team findById(int id);
}
