package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.CompetitionRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.exception.PersonNotFoundException;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCompetitionRepository implements CompetitionRepository {


    private List<Competition> competitionList = new ArrayList<>();

    public InMemoryCompetitionRepository() {
        Competition szachy = new Competition("SZA", "Szachy");
//        szachy.setAuthor(new Person("P1","Patryk","Krzyzanowski"));
//        szachy.setRules("Kazdy gra z kazdym.");
//
        Competition rzutki = new Competition("RZU", "Rzutki");
//        rzutki.setAuthor(new Person("P1","Patryk","Krzyzanowski"));
//        rzutki.setRules("Gramy od 301 w dol.");

        Competition pingPing = new Competition("PIN", "PingPong");
//        pingPing.setAuthor(new Person("M1","Marcin","Skalkowski"));
//        pingPing.setRules("Kazdy z kazdym jednen set do dwoch wygranych gemow.");

        Competition grid = new Competition("PIN", "Grid");
//        pingPing.setAuthor(new Person("M1","Marcin","Skalkowski"));
//        pingPing.setRules("Jeden wyscig, kazdy z kazdym.");

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
        competitionList.add(competition);
    }

    @Override
    public void removeCompetition(String competitionId) {
        if (!competitionList.contains(getCompetitionById(competitionId))) {
            throw new IllegalArgumentException(String.format("Produkt o wskazanym id (%) nie istnieje", competitionId));
        }
        competitionList.remove(getCompetitionById(competitionId));
    }

    @Override
    public Competition getCompetitionById(String competitionId) {

        Competition competitionById = null;

        for (Competition competition : competitionList) {
            if (competition != null && competition.getCompetitionId() != null && competitionId.equals(competition.getCompetitionId())) {
                competitionById = competition;
            }
        }
        if (competitionById == null) {
            throw new CompetitionNotFoundException(competitionId);
        }
        return competitionById;

    }
}
