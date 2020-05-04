package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.MeetingTime;
import com.packt.xivboj.service.CourseService;
import com.packt.xivboj.service.MeetingTimeService;
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
@RequestMapping("/meetingTimes")
public class MeetingTimeController {

    @Autowired
    MeetingTimeService meetingTimeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewMeetingTime(Model model) {
        MeetingTime newMeetingTime = new MeetingTime();
        model.addAttribute("newMeetingTime", newMeetingTime);
        return "registrationMeetingTime";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewRoom(@ModelAttribute("newMeetingTime") @Valid MeetingTime meetingTimeToBeAdded, BindingResult result, HttpServletRequest request) {

        meetingTimeService.addMeetingTime(meetingTimeToBeAdded);

        return "redirect:/people";
    }
}
