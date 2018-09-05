package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.CompetitionRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.exception.PersonNotFoundException;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCompetitionRepository implements CompetitionRepository {


    @Autowired private DataSource dataSource;

    private List<Competition> competitionList = new ArrayList<>();

    public InMemoryCompetitionRepository() {


//        Competition szachy = new Competition("1", "Szachy");
////        szachy.setAuthor(new Person("P1","Patryk","Krzyzanowski"));
//        szachy.setRules("Kazdy gra z kazdym.");
//        szachy.setPreferedTime(60);
////
//        Competition rzutki = new Competition("2", "Rzutki");
////        rzutki.setAuthor(new Person("P1","Patryk","Krzyzanowski"));
//        rzutki.setRules("Gramy od 301 w dol.");
//        rzutki.setPreferedTime(30);
//
//        Competition pingPing = new Competition("3", "PingPong");
////        pingPing.setAuthor(new Person("M1","Marcin","Skalkowski"));
//        pingPing.setRules("Kazdy z kazdym jednen set do dwoch wygranych gemow.");
//        pingPing.setPreferedTime(70);
//
//        Competition grid = new Competition("4", "Grid");
////        pingPing.setAuthor(new Person("M1","Marcin","Skalkowski"));
//        grid.setRules("Jeden wyscig, kazdy z kazdym.");
//        grid.setPreferedTime(50);

//        competitionList.add(szachy);
//        competitionList.add(rzutki);
//        competitionList.add(pingPing);
//        competitionList.add(grid);
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
    public void nowa() {


        String sql = "SELECT * FROM competition ";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Competition competition = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                competition = new Competition();
                competition.setName("abc");

                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println(sql);
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
