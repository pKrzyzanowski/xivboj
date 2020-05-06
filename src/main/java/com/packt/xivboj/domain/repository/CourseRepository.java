package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.Room;

import java.util.List;

public interface CourseRepository {
    void addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(int id);

    void delete(int courseId);
}
