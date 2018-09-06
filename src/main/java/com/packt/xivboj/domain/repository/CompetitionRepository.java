package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Competition;

import java.util.List;

public interface CompetitionRepository {

    public List<Competition> getAllCompetitions();

    public void addCompetition(Competition competition);

    public void removeCompetition(int competitionId);

    public Competition getCompetitionById(int competitionId);

    public void nowa();

    public void initializeBasicCompetitions();

}
