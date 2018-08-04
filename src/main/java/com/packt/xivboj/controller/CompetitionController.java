package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;


    @RequestMapping
    public String list(Model model) {
        model.addAttribute("competitions", competitionService.getAllCompetitions());
        return "competitions";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewCompetition(Model model) {
        Competition newCompetition = new Competition();
        model.addAttribute("newCompetition", newCompetition);
        return "addCompetition";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewCompetition(@ModelAttribute("newCompetition") Competition competitionToBeAdded) {
        competitionService.addCompetition(competitionToBeAdded);
        return "redirect:/competitions";
    }
}
