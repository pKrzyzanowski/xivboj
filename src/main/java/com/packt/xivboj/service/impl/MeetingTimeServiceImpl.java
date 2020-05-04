package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.MeetingTime;
import com.packt.xivboj.domain.repository.CourseRepository;
import com.packt.xivboj.domain.repository.MeetingTimeRepository;
import com.packt.xivboj.service.MeetingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingTimeServiceImpl implements MeetingTimeService {

    @Autowired
    MeetingTimeRepository meetingTimeRepository;

    @Override
    public void addMeetingTime(MeetingTime meetingTime) {
        meetingTimeRepository.addMeetingTime(meetingTime);
    }
}
