package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.CompetitionRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.exception.PersonNotFoundException;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCompetitionRepository implements CompetitionRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Autowired
    EntityManager myEntityManager;

    @Bean
    EntityManager myEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


//    @PersistenceContext(unitName = "mybase")
//    EntityManager myEntityManager;

    private List<Competition> competitionList = new ArrayList<>();


    public InMemoryCompetitionRepository() {


    }



    @Override
    @Transactional
    public List<Competition> getAllCompetitions() {
//        myEntityManager.getTransaction().begin();
//        Competition competition1 = myEntityManager.persist();
        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM competition",Competition.class);
        List<Competition> resultList = nativeQuery.getResultList();
//        myEntityManager.getTransaction().commit();
        return resultList;
    }

    public void initializeBasicCompetitions() {


//        Competition szachy = new Competition(1, "Szachy");
////        szachy.setAuthor(new Person("P1","Patryk","Krzyzanowski"));
//        szachy.setRules("Kazdy gra z kazdym.");
//        szachy.setPreferedTime(60);
////
//        Competition rzutki = new Competition(2, "Rzutki");
////        rzutki.setAuthor(new Person("P1","Patryk","Krzyzanowski"));
//        rzutki.setRules("Gramy od 301 w dol.");
//        rzutki.setPreferedTime(30);
//
//        Competition pingPing = new Competition(3, "PingPong");
////        pingPing.setAuthor(new Person("M1","Marcin","Skalkowski"));
//        pingPing.setRules("Kazdy z kazdym jednen set do dwoch wygranych gemow.");
//        pingPing.setPreferedTime(70);
//
//
//        Competition grid = new Competition(4, "Grid");
////        pingPing.setAuthor(new Person("M1","Marcin","Skalkowski"));
//        grid.setRules("Jeden wyscig, kazdy z kazdym.");
//        grid.setPreferedTime(50);
//
//
//        myEntityManager.getTransaction().begin();
//        myEntityManager.persist(grid);
//        myEntityManager.persist(pingPing);
//        myEntityManager.persist(rzutki);
//        myEntityManager.persist(szachy);
//        myEntityManager.getTransaction().commit();
//


//        myEntityManager.getTransaction().begin();
//
//        Competition szachyBase  = myEntityManager.find(Competition.class,1);
//        Competition rzutkiBase  = myEntityManager.find(Competition.class,2);
//        Competition pingPingBase  = myEntityManager.find(Competition.class,3);
//        Competition gridBase  = myEntityManager.find(Competition.class,4);
//
//        myEntityManager.getTransaction().commit();
//
//        competitionList.add(szachyBase);
//        competitionList.add(rzutkiBase);
//        competitionList.add(pingPingBase);
//        competitionList.add(gridBase);
    }

    @Override
    @Transactional
    public void addCompetition(Competition competition) {


        myEntityManager.getTransaction().begin();
//        Competition competition1 = myEntityManager.persist();
        myEntityManager.persist(competition);

        myEntityManager.getTransaction().commit();

        competitionList.add(competition);
//        Competition competition1 = entityManager.find(Competition.class,"Our very first competition!");
//        entityManager.persist(new Competition("S23", "Nazxwa"));
//
//
        myEntityManager.close();
//        myEntityManager.getTransaction().commit();
//        myEntityManager.refresh(competition);
//        entityManager.getTransaction().begin();
//        entityManager.persist(new Competition("S23", "Nazxwa"));
//        entityManager.getTransaction().commit();
//


//        myEntityManager.getTransaction().begin();
//
//        Competition competition1 = myEntityManager.find(Competition.class, 7);
//        myEntityManager.getTransaction().commit();
//
//
//        try {
//            if (!competitionList.contains(getCompetitionById(7))) {
//                competitionList.add(competition1);
//            }
//
//        } catch (CompetitionNotFoundException e) {
//            competitionList.add(competition1);
//        }

    }

    @Override
    public void removeCompetition(int competitionId) {
        if (!competitionList.contains(getCompetitionById(competitionId))) {
            throw new IllegalArgumentException(String.format("Produkt o wskazanym id (%) nie istnieje", competitionId));
        }
        competitionList.remove(getCompetitionById(competitionId));
    }

    @Override
    public void nowa() {

    }

    @Override
    @Transactional
    public Competition getCompetitionById(int competitionId) {

        Competition competitionById = null;

//        myEntityManager.getTransaction().begin();
        competitionById= myEntityManager.find(Competition.class, competitionId);
//        myEntityManager.getTransaction().commit();


        if (competitionById == null) {
            throw new CompetitionNotFoundException(competitionId);
        }
        return competitionById;

    }


}
