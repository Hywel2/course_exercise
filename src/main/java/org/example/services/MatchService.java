package org.example.services;

import java.util.List;

import org.example.entities.Match;
import org.example.repositories.MatchDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MatchService {
    MatchDao matchRepository;

    public MatchService(MatchDao matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void addMatch(Match match){
        matchRepository.saveMatch(match);
    }

    public List<Match> viewMatches(){
        return matchRepository.getMatches(); 
    }
    
    public void deleteMatch(int id){
        matchRepository.deleteMatch(id);
    }
}
