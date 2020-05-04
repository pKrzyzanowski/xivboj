package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.service.PersonService;
import com.packt.xivboj.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/rooms")
public class RoomController {


    @Autowired
    RoomService roomService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewRoom(Model model) {
        Room newRoom = new Room();
        model.addAttribute("newRoom", newRoom);
        return "registrationRoom";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewRoom(@ModelAttribute("newRoom") @Valid Room roomToBeAdded, BindingResult result, HttpServletRequest request) {
//        Person existingPerson;
//        existingPerson = personService.getPersonByUserName(InstructortoBeAdded.getUsername());

//        if (result.hasErrors() || existingPerson != null) {
//            return "registration";
//        }

        roomService.addRoom(roomToBeAdded);
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






}
