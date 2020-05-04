package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.InstructorRepository;
import com.packt.xivboj.domain.repository.PersonRepository;
import com.packt.xivboj.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public void addInstructor(Instructor instructor) {
        instructorRepository.addInstructor(instructor);
    }
}
