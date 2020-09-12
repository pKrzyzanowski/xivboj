package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.MeetingTime;
import com.packt.xivboj.domain.Room;

import java.util.List;

public interface MeetingTimeRepository {
    void addMeetingTime(MeetingTime meetingTime);
    List<MeetingTime> getAllMeetingTimes();

}
