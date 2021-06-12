package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Team;

/**
 * Репозиторий для команд.
 *
 * @author Николай Евсюков
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    /**
     * Поиск команды по ее названию.
     *
     * @param name название команды
     * @return найденная команда
     */
    Team findByName(String name);
}
