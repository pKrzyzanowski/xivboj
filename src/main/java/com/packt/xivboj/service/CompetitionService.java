package com.packt.xivboj.service;

import com.packt.xivboj.domain.Competition;

import java.util.List;

public interface CompetitionService {

    public List<Competition> getAllCompetitions();

    public void addCompetition(String competitionId);

    public void removeCompetition(String competitionId);

    public Competition getCompetitionById(String competitionId);
}
