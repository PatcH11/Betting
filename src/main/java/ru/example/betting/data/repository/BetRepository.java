package ru.example.betting.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.betting.data.model.Bet;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, Integer> {

    List<Bet> getAllByUserUsername(String username);
}
