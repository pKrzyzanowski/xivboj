package com.packt.xivboj.service;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.Room;

import java.util.List;

public interface InstructorService {
    void addInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(int id);
    void delete(int instructorId);
}
