package com.packt.xivboj.domain;

import java.util.List;

public class Data {
    List<Room> rooms;
    List<MeetingTime> meetingTimes;
    List<Instructor> instructors;
    List<Course> courses;

    public Data(List<Room> rooms, List<MeetingTime> meetingTimes, List<Instructor> instructors, List<Course> courses) {
        this.rooms = rooms;
        this.meetingTimes = meetingTimes;
        this.instructors = instructors;
        this.courses = courses;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<MeetingTime> getMeetingTimes() {
        return meetingTimes;
    }

    public void setMeetingTimes(List<MeetingTime> meetingTimes) {
        this.meetingTimes = meetingTimes;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
