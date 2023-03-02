package org.example.repositories;

import java.util.List;

import org.example.entities.Match;

public interface MatchDao {
    void saveMatch(Match match);
    
    List<Match> getMatches();

    void deleteMatch(int id);
}
