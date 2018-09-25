package com.packt.xivboj.controller;


import com.mysql.cj.xdevapi.Collection;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
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

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;


    @RequestMapping
    public String results(Model model)
    {





        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();


//        String query = "SELECT allCartCompe_competitionId FROM cartcompetition WHERE Cart_cartId = " + "\"" + cartId + "\"";
//        Query nativeQuery = myEntityManager.createNativeQuery(query);
//        List<Integer> resultList = nativeQuery.getResultList();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM competition", Competition.class);
        List<Competition> competitionList = nativeQuery.getResultList();
        Collections.sort(competitionList);
        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        int treshHold = competitionList.get(14).getPersonList().size();
        model.addAttribute("competitionList", competitionList);
        model.addAttribute("treshHold", treshHold);
        return "results";
    }


}
