package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.repository.CompetitionRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCompetitionRepository implements CompetitionRepository {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    public InMemoryCompetitionRepository() {
    }

    @Override
    @Transactional
    public List<Competition> getAllCompetitions() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM competition", Competition.class);
        List<Competition> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return resultList;
    }

    public void initializeBasicCompetitions() {
    }

    @Override
    @Transactional
    public void addCompetition(Competition competition) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        myEntityManager.persist(competition);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
    }
    @Transactional
    @Override
    public void removeCompetition(int competitionId) {
//        if (!competitionList.contains(getCompetitionById(competitionId))) {
//            throw new IllegalArgumentException(String.format("Produkt o wskazanym id (%) nie istnieje", competitionId));
//        }
//        competitionList.remove(getCompetitionById(competitionId));
    }

    @Override
    @Transactional
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
