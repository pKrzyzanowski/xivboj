package com.packt.xivboj.service;

import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.MeetingTime;
import com.packt.xivboj.domain.Room;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(int id);

    void delete(int courseId);
}
