package com.packt.xivboj.service;

import com.packt.xivboj.domain.Competition;

import java.util.List;

public interface CompetitionService {

    List<Competition> getAllCompetitions();

    void addCompetition(Competition competition);

    Competition getCompetitionById(int competitionId);

}
