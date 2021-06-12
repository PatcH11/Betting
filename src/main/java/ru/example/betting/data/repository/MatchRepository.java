package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Match;

/**
 * Репозиторий для матчей.
 *
 * @author Николай Евсюков
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    /**
     * Поиск матча по ID команды.
     *
     * @param homeId ID домашней команды
     * @param awayId ID гостевой команды
     * @return найденный матч
     */
    Match findByHomeIdOrAwayId(int homeId, int awayId);
}
