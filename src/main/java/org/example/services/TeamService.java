package org.example.services;

import java.util.List;

import org.example.entities.Team;
import org.example.repositories.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeamService {
    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    
    public void addTeam(Team team){
        teamRepository.saveTeam(team);
    }

    public List<Team> viewTeams(){
        return teamRepository.getTeams();
    }

    public void deleteTeam(int id){
        teamRepository.deleteTeam(id);
    }
}
