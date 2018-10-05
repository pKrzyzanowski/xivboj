package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.CompetitionRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCompetitionRepository implements CompetitionRepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public InMemoryCompetitionRepository() {
    }

    @Override
    public List<Competition> getAllCompetitions() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM competition", Competition.class);
        List<Competition> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return resultList;
    }

    @Override
    public void addCompetition(Competition competition) {

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Competition competitionFromDb = null;
        try {
            Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM competition where name =" + "\"" + competition.getName() + "\"", Competition.class);
            competitionFromDb = (Competition) nativeQuery.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        if (competitionFromDb == null) {
            myEntityManager.persist(competition);
        }

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
    }

    @Override
    public void removeCompetition(int competitionId) {
    }

    @Override
    public Competition getCompetitionById(int competitionId) {

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Competition competitionById = null;
        competitionById = myEntityManager.find(Competition.class, competitionId);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        if (competitionById == null) {
            throw new CompetitionNotFoundException(competitionId);
        }
        return competitionById;
    }


}
