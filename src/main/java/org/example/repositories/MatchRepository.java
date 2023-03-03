package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import org.example.entities.Match;
import org.springframework.stereotype.Repository;

@Repository
public class MatchRepository implements MatchDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void saveMatch(Match match) {
        entityManager.persist(match);
    }

    @Override
    public List<Match> getMatches() {
        return entityManager.createQuery("from Match", Match.class).getResultList();
    }

    @Override
    public void deleteMatch(int id) {
        var match = entityManager.find(Match.class, id);
        if (match != null) {
            entityManager.remove(match);
        }
    }
}
