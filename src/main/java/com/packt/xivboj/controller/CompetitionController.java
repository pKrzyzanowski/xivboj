package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("competitions", competitionService.getAllCompetitions());
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
//        String a = "asd";
        competitionService.initializeBasicCompetitions();
        return "competitions";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewCompetition(Model model) {
        Competition newCompetition = new Competition();
        model.addAttribute("newCompetition", newCompetition);
        return "addCompetition";
    }

    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public String voteForCompetitions(Model model) {

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();


        String query = "SELECT * FROM person where username =\"" +currentPrincipalName+ "\"";
        Query nativeQuery = myEntityManager.createNativeQuery(query , Person.class);
        Person currentUser =(Person) nativeQuery.getSingleResult();
        int currentUserId = currentUser.getNameId();

        query = "SELECT * FROM cart where person_nameId =" +currentUserId;
        Query nativeQuery2 = myEntityManager.createNativeQuery(query , Cart.class);
        Cart currentUsersCart = (Cart) nativeQuery2.getSingleResult();
        String currentUsersCartId = currentUsersCart.getCartId();


        List<Competition> competitions = new ArrayList<Competition>();
        // pobranie kart z uzytkownika
        // competitions = pobranie wielu konkurencji z karty
        //przypisanie uzytkownikowi konkurencji
        competitions = currentUser.getCompetitionList();
        Collection<Competition> newCompetitions = new ArrayList<Competition>();
        newCompetitions = currentUsersCart.getAllCartCompe();
//        competitions.add(newCompetitions);
//        currentUser.setCompetitionList();


        myEntityManager.getTransaction().commit();
        myEntityManager.close();



        return "cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewCompetition(@ModelAttribute("newCompetition") @Valid Competition competitionToBeAdded, HttpServletRequest request, BindingResult result) {

        if (result.hasErrors()) {
            return "addCompetition";
        }

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
