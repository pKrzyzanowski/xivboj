package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {


    @Autowired
    CompetitionService competitionService;

    @RequestMapping("/")
    public String welcome(Model model) {


        model.addAttribute("greeting", "Witaj w sklepie internetowym! ");
        model.addAttribute("tagline", "Wyjątkowym i jedynym sklepie internetowym");

        return "welcome";
    }




}
