package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Person;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
        model.addAttribute("person", personService.getPersonById(personId));
        return "person";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewPerson(Model model) {
        Person newPerson = new Person();
        model.addAttribute("newPerson", newPerson);
        return "registration";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewPerson(@ModelAttribute("newPerson") Person personToBeAdded, HttpServletRequest request, BindingResult result) {

        personService.addPerson(personToBeAdded);

        return "redirect:/people";
    }
}
