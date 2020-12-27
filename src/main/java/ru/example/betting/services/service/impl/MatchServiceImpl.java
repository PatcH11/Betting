package ru.example.betting.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.betting.data.model.Match;
import ru.example.betting.data.repository.MatchRepository;
import ru.example.betting.services.service.IMatchService;

import java.util.List;

@Service
public class MatchServiceImpl implements IMatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match findByHomeIdOrAwayId(int homeId, int awayId) {
        return matchRepository.findByHomeIdOrAwayId(homeId, awayId);
    }
}
