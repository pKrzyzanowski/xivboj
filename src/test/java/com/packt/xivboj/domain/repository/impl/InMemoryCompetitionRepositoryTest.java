package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCompetitionRepositoryTest {

    private List<Competition> competitionList = new ArrayList<>();


    @Test
    public void method_getAllCompetitions_should_return_Competiotion_Object_If_exists_any() {


        Competition szachy = new Competition("SZA", "Szachy");

        competitionList.add(szachy);


    }


}
