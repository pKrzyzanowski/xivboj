package com.packt.xivboj.controller;


import com.mysql.cj.xdevapi.Collection;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/results")
public class ResultsController {

    @Autowired
    CompetitionService competitionService;

    @RequestMapping
    public String results(Model model) {

        List<Competition> competitionList = competitionService.getAllCompetitions();
        Collections.sort(competitionList);

        int threshold = 0;
        if (competitionList.size() > 12) {
            threshold = competitionList.get(13).getPersonList().size();
        }
        model.addAttribute("competitionList", competitionList);
        model.addAttribute("threshold", threshold);
        return "results";
    }


}
