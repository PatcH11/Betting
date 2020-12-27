package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    Match findByHomeIdOrAwayId(int homeId, int awayId);
}
