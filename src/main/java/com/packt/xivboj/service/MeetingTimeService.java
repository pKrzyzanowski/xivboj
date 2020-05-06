package com.packt.xivboj.service;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.MeetingTime;
import com.packt.xivboj.domain.Room;

import java.util.List;

public interface MeetingTimeService {
    void addMeetingTime(MeetingTime meetingTime);
    List<MeetingTime> getAllMeetingTimes();

}
