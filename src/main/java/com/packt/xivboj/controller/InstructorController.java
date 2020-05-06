package com.packt.xivboj.controller;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.service.InstructorService;
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
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("instructors", instructorService.getAllInstructors());
        return "instructors";
    }



    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewInstructor(Model model) {
        Instructor newInstructor = new Instructor();
        model.addAttribute("newInstructor", newInstructor);
        return "addInstructor";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewInstructor(@ModelAttribute("newInstructor") @Valid Instructor instructorToBeAdded, BindingResult result, HttpServletRequest request) {
        instructorService.addInstructor(instructorToBeAdded);

        return "redirect:/people";
    }


}
