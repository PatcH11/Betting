package ru.example.betting.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.betting.data.model.Bet;
import ru.example.betting.data.repository.BetRepository;
import ru.example.betting.services.service.IBetService;

import java.util.List;

@Service
public class BetServiceImpl implements IBetService {

    private final BetRepository betRepository;

    @Autowired
    public BetServiceImpl(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @Override
    public Bet create(Bet bet) {
        return betRepository.save(bet);
    }

    @Override
    public List<Bet> getAllByUserUsername(String username) {
        return betRepository.getAllByUserUsername(username);
    }
}
