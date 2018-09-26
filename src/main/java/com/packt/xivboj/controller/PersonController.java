package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Person;
import com.packt.xivboj.exception.PersonNotFoundException;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String processAddNewPerson( @ModelAttribute("newPerson")@Valid  Person personToBeAdded,BindingResult result, HttpServletRequest request ) {


        if(result.hasErrors()) {
            return "registration";
        }

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
    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("name","surname","age","description","personImage","username","password");
        binder.setDisallowedFields("cart", "enabled","role");
    }


}
