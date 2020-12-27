package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    Team findByName(String name);
}
