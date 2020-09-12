package com.packt.xivboj.controller.rest;

import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.repository.impl.InMemoryBaseRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/course")
public class CourseRestController extends InMemoryBaseRepository {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/remove/{courseId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int courseId) {
        final Course course = courseService.getCourseById(courseId);

        if (course == null) {
            throw new IllegalArgumentException(new CompetitionNotFoundException(courseId));
        }
        courseService.delete(courseId);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

}
