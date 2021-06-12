package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Score;

/**
 * Репозиторий для счета.
 *
 * @author Николай Евсюков
 */
@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
