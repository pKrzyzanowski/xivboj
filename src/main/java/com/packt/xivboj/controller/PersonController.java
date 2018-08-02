package com.packt.xivboj.controller;


import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("people", personService.getAllPersons());
        return "persons";
    }

    @RequestMapping("/person")
    public String getPersonById(@RequestParam("personId") String personId, Model model) {
        model.addAttribute("person",personService.getPersonById(personId) );
        return "person";
    }
}
