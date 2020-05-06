package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Course;
import com.packt.xivboj.service.CourseService;
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
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewCourse(Model model) {
        Course newCourse = new Course();
        model.addAttribute("newCourse", newCourse);
        return "addCourse";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewRoom(@ModelAttribute("newCourse") @Valid Course courseToBeAdded, BindingResult result, HttpServletRequest request) {

        courseService.addCourse(courseToBeAdded);

        return "redirect:/courses";
    }
}
