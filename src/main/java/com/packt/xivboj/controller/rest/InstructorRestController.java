package com.packt.xivboj.controller.rest;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.repository.impl.InMemoryBaseRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/instructor")
public class InstructorRestController extends InMemoryBaseRepository {

    @Autowired
    private InstructorService instructorService;

    @RequestMapping(value = "/remove/{instructorId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int instructorId) {
        final Instructor instructor = instructorService.getInstructorById(instructorId);

        if (instructor == null) {
            throw new IllegalArgumentException(new CompetitionNotFoundException(instructorId));
        }
        instructorService.delete(instructorId);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

}
