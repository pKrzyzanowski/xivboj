package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Competition;

import java.util.List;

public interface CompetitionRepository {

     List<Competition> getAllCompetitions();

     void addCompetition(Competition competition);

     void removeCompetition(int competitionId);

     Competition getCompetitionById(int competitionId);

     void initializeBasicCompetitions();

}
