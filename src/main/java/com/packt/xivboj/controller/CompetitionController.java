package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;


@Controller
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;



    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

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
    public String processAddNewCompetition(@ModelAttribute("newCompetition") @Valid Competition competitionToBeAdded, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addCompetition";
        }

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT name FROM person where username = " + "\""
                + SecurityContextHolder.getContext().getAuthentication().getName() + "\"");
        String personName = (String) nativeQuery.getSingleResult();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        competitionToBeAdded.setAutorsName(personName);
        competitionService.addCompetition(competitionToBeAdded);

        MultipartFile competitionImage = competitionToBeAdded.getCompetitionImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (competitionImage != null && !competitionImage.isEmpty()) {
            try {
                competitionImage.transferTo(new File(rootDirectory + "resources\\images\\competitions\\" + competitionToBeAdded.getCompetitionId() + ".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("niepowodzenie podczas proby zapisu obrazka", e);
            }
        }
        return "redirect:/competitions";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("competitionId", "name", "rules", "preferedTime", "competitionImage");
    }

    @RequestMapping(value = "/competition")
    public String getCompetitionById(@RequestParam(value = "id") int competitionId, Model model) {
        model.addAttribute("competition", competitionService.getCompetitionById(competitionId));
        return "competition";
    }
}
