package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;


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
    public String processAddNewCompetition(@ModelAttribute("newCompetition") @Valid Competition competitionToBeAdded, HttpServletRequest request,BindingResult result) {

        if (result.hasErrors()) {
            return "addCompetition";
        }

        competitionService.addCompetition(competitionToBeAdded);

        MultipartFile competitionImage = competitionToBeAdded.getCompetitionImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (competitionImage != null && !competitionImage.isEmpty()) {
            try {
                competitionImage.transferTo(new File(rootDirectory + "resources\\images\\" + competitionToBeAdded.getCompetitionId() + ".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("niepowodzenie podczas proby zapisu obrazka", e);
            }
        }

        return "redirect:/competitions";
    }




    @RequestMapping(value = "/competition")
    public String getCompetitionById(@RequestParam(value = "id") String competitionId, Model model) {
        model.addAttribute("competition", competitionService.getCompetitionById(competitionId));
        return "competition";
    }
}
