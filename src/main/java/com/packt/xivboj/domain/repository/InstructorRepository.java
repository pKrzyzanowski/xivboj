package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Room;

import java.util.List;

public interface InstructorRepository {
    void addInstructor(Instructor instructor);
    Instructor getInstructorById(int id);
    List<Instructor> getAllInstructors();
    void delete(int instructorId);
}
