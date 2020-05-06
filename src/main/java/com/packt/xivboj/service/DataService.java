package com.packt.xivboj.service;


import com.packt.xivboj.domain.*;

import java.util.List;

public interface DataService {

    Data getAllData();

    List<Room> getAllRooms();

    List<MeetingTime> getAllMeetingTimes();

    List<Instructor> getAllInstructors();

    List<Course> getAllCourses();
}
