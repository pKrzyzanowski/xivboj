package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.impl.BaseRepositoryTransaction;
import com.packt.xivboj.domain.repository.impl.InMemoryBaseRepository;
import com.packt.xivboj.service.CartService;
import com.packt.xivboj.service.InstructorService;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;

import static com.packt.xivboj.util.PrincipalUtil.getCurrentUserCartName;

@Controller
@RequestMapping("/people")
public class PersonController extends InMemoryBaseRepository {

    @Autowired
    PersonService personService;

    @Autowired
    InstructorService instructorService;

    @Autowired
    CartService cartService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("people", personService.getAllPersons());
        return "persons";
    }

    @RequestMapping("/person")
    public String getPersonById(@RequestParam("personId") int personId, Model model) {
        Person person = personService.getPersonById(personId);
        model.addAttribute("person", person);
        return "person";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewPerson(Model model) {
        Person newPerson = new Person();
        model.addAttribute("newPerson", newPerson);
        return "registration";
    }

    @RequestMapping(value = "/addInstructor", method = RequestMethod.GET)
    public String getAddNewInstructor(Model model) {
        Instructor newInstructor = new Instructor();
        model.addAttribute("newInstructor", newInstructor);
        return "registrationInstructor";
    }

    @RequestMapping(value = "/addInstructor", method = RequestMethod.POST)
    public String processAddNewInstructor(@ModelAttribute("newInstructor") @Valid Instructor instructorToBeAdded, BindingResult result, HttpServletRequest request) {
        Person existingPerson;
//        existingPerson = personService.getPersonByUserName(InstructortoBeAdded.getUsername());

//        if (result.hasErrors() || existingPerson != null) {
//            return "registration";
//        }

        instructorService.addInstructor(instructorToBeAdded);
//        Cart cart = new Cart();
//        cart.setCartId(personToBeAdded.getUsername() + "sCart");
//        personToBeAdded.setCart(cart);
//        cart.setPerson(personToBeAdded);
//        cartService.create(cart);

//        MultipartFile personImage = personToBeAdded.getPersonImage();
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        if (personImage != null && !personImage.isEmpty()) {
//            try {
//                personImage.transferTo(new File(rootDirectory + "resources\\images\\persons\\" + personToBeAdded.getNameId() + ".jpg"));
//            } catch (Exception e) {
//                throw new RuntimeException("niepowodzenie podczas proby zapisu obrazka", e);
//            }
//        }
        return "redirect:/people";
    }





    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewPerson(@ModelAttribute("newPerson") @Valid Person personToBeAdded, BindingResult result, HttpServletRequest request) {
        Person existingPerson;
        existingPerson = personService.getPersonByUserName(personToBeAdded.getUsername());

        if (result.hasErrors() || existingPerson != null) {
            return "registration";
        }

        personService.addPerson(personToBeAdded);
        Cart cart = new Cart();
        cart.setCartId(personToBeAdded.getUsername() + "sCart");
        personToBeAdded.setCart(cart);
        cart.setPerson(personToBeAdded);
        cartService.create(cart);

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
        binder.setAllowedFields("name", "surname", "age", "description", "personImage", "username", "password");
        binder.setDisallowedFields("cart", "enabled", "role");
    }
}