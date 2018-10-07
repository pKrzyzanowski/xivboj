package com.packt.xivboj.service.impl;


import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.repository.CompetitionRepository;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {


    @Autowired
    CompetitionRepository competitionRepository;

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.getAllCompetitions();
    }

    @Override
    public void addCompetition(Competition competition) {
        competitionRepository.addCompetition(competition);
    }

    @Override
    public Competition getCompetitionById(int competitionId) {
        return competitionRepository.getCompetitionById(competitionId);
    }

    @Override
    public List<Integer> getListOfCompetitionsIdByCartName(String cartName) {
        return competitionRepository.getListOfCompetitionsIdByCartName(cartName);
    }

    @Override
    public List<Integer> getListOfCompetitionIdFromUserVotes(Integer userId) {
        return competitionRepository.getListOfCompetitionIdFromUserVotes(userId);
    }


}
