package ru.example.betting.services.service;

import ru.example.betting.data.model.Bet;

import java.util.List;

public interface IBetService {

    Bet create(Bet bet);

    List<Bet> getAllByUserUsername(String username);
}
