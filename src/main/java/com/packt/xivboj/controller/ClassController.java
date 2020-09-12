package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Class;
import com.packt.xivboj.domain.Course;
import com.packt.xivboj.service.ClassService;
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
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewClass(Model model) {
        Class newClass = new Class();
        model.addAttribute("newClass", newClass);
        return "registrationClass";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewRoom(@ModelAttribute("newClass") @Valid Class classToBeAdded, BindingResult result, HttpServletRequest request) {

        classService.addClass(classToBeAdded);

        return "redirect:/people";
    }

}
