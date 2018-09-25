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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

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
    public String getPersonById(@RequestParam("personId") int personId, Model model) {
        Person person = personService.getPersonById(personId);
        model.addAttribute("person",person);
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

        MultipartFile personImage = personToBeAdded.getPersonImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (personImage != null && !personImage.isEmpty()) {
            try {
                personImage.transferTo(new File(rootDirectory + "resources\\images\\persons\\" + personToBeAdded.getNameId() + ".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("niepowodzenie podczas proby zapisu obrazka", e);
            }
        }




        return "redirect:/people";
    }
}
