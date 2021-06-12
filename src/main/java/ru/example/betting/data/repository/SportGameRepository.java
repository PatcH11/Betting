package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.SportGame;

/**
 * Репозиторий для вида спортивной игры
 *
 * @author Николай Евсюков.
 */
@Repository
public interface SportGameRepository extends JpaRepository<SportGame, Integer> {
}
