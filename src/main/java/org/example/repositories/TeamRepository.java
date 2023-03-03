package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import org.example.entities.Team;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepository implements TeamDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveTeam(Team team) {
        entityManager.persist(team);
    }

    @Override
    public List<Team> getTeams() {
        return entityManager.createQuery("from Team", Team.class).getResultList();
    }

    @Override
    public void deleteTeam(int id) {
        var team = entityManager.find(Team.class, id);

        if (team != null) {
            entityManager.remove(team);
        }
    }
}
