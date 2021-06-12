package ru.example.betting.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.betting.data.model.Team;
import ru.example.betting.data.repository.TeamRepository;
import ru.example.betting.services.service.ITeamService;

/**
 * Реализация интерфейса ITeamService.
 *
 * @author Николай Евсюков
 */
@Service
public class TeamServiceImpl implements ITeamService {

    /**
     * Репозиторий для команды.
     */
    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findById(int id) {
        return teamRepository.findById(id).get();
    }
}
