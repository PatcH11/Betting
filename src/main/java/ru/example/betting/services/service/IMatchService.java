package ru.example.betting.services.service;

import ru.example.betting.data.model.Match;

import java.util.List;

public interface IMatchService {

    List<Match> getMatches();

    Match findByHomeIdOrAwayId(int homeId, int awayId);
}
