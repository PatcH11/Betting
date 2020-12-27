package ru.example.betting.services.service;

import ru.example.betting.data.model.Team;

public interface ITeamService {

    Team findById(int id);
}
