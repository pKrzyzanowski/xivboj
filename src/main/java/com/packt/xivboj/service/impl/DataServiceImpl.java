package com.packt.xivboj.service.impl;


import com.packt.xivboj.domain.*;
import com.packt.xivboj.domain.repository.CourseRepository;
import com.packt.xivboj.domain.repository.InstructorRepository;
import com.packt.xivboj.domain.repository.MeetingTimeRepository;
import com.packt.xivboj.domain.repository.RoomRepository;
import com.packt.xivboj.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    MeetingTimeRepository meetingTimeRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Data getAllData() {
        return new Data(getAllRooms(),getAllMeetingTimes(), getAllInstructors(),getAllCourses());
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public List<MeetingTime> getAllMeetingTimes() {
        return meetingTimeRepository.getAllMeetingTimes();
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.getAllInstructors();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }
}
