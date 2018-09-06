package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.CompetitionRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.exception.PersonNotFoundException;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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


    @Bean
    EntityManager myEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Autowired
    EntityManager myEntityManager;
    private List<Competition> competitionList = new ArrayList<>();


    public InMemoryCompetitionRepository() {


        Competition szachy = new Competition(1, "Szachy");
//        szachy.setAuthor(new Person("P1","Patryk","Krzyzanowski"));
        szachy.setRules("Kazdy gra z kazdym.");
        szachy.setPreferedTime(60);
//
        Competition rzutki = new Competition(2, "Rzutki");
//        rzutki.setAuthor(new Person("P1","Patryk","Krzyzanowski"));
        rzutki.setRules("Gramy od 301 w dol.");
        rzutki.setPreferedTime(30);

        Competition pingPing = new Competition(3, "PingPong");
//        pingPing.setAuthor(new Person("M1","Marcin","Skalkowski"));
        pingPing.setRules("Kazdy z kazdym jednen set do dwoch wygranych gemow.");
        pingPing.setPreferedTime(70);


        Competition grid = new Competition(4, "Grid");
//        pingPing.setAuthor(new Person("M1","Marcin","Skalkowski"));
        grid.setRules("Jeden wyscig, kazdy z kazdym.");
        grid.setPreferedTime(50);

        competitionList.add(szachy);
        competitionList.add(rzutki);
        competitionList.add(pingPing);
        competitionList.add(grid);
    }

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionList;
    }

    @Override
    public void addCompetition(Competition competition) {
//        competitionList.add(competition);


        myEntityManager.getTransaction().begin();
//        Competition competition1 = myEntityManager.persist();
        myEntityManager.getTransaction().commit();

//        Competition competition1 = entityManager.find(Competition.class,"Our very first competition!");
//        entityManager.persist(new Competition("S23", "Nazxwa"));
//
//

//        entityManager.getTransaction().begin();
//        entityManager.persist(new Competition("S23", "Nazxwa"));
//        entityManager.getTransaction().commit();

        myEntityManager.getTransaction().begin();

        Competition competition1 = myEntityManager.find(Competition.class, 7);
        myEntityManager.getTransaction().commit();


//        entityManager.close();
//        entityManagerFactory.close();
        try {
            if (!competitionList.contains(getCompetitionById(7))) {
                competitionList.add(competition1);
            }

        } catch (CompetitionNotFoundException e ) {
            competitionList.add(competition1);
        }

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

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Competition(6, "Nazwa"));

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Competition getCompetitionById(int competitionId) {

        Competition competitionById = null;

        for (Competition competition : competitionList) {
            if (competition != null && competitionId==(competition.getCompetitionId())) {
                competitionById = competition;
            }
        }
        if (competitionById == null) {
            throw new CompetitionNotFoundException(competitionId);
        }
        return competitionById;

    }


}
