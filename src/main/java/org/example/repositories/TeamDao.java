package org.example.repositories;

import java.util.List;

import org.example.entities.Team;

public interface TeamDao {
    void saveTeam(Team team);
    
    List<Team> getTeams();
    
    void deleteTeam(int id);
}
