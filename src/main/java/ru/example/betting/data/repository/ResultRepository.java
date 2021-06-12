package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Result;

/**
 * Репозиторий для результата матча.
 *
 * @author Николай Евсюков
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
}
