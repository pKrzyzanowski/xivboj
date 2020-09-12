package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.CourseRepository;
import com.packt.xivboj.domain.repository.RoomRepository;
import com.packt.xivboj.service.CourseService;
import com.packt.xivboj.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public void delete(int courseId) {
        courseRepository.delete(courseId);
    }
}


