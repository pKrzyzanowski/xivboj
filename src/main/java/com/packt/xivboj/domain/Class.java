package com.packt.xivboj.domain;


import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    Course course;

    @ManyToOne
    Instructor instructor;

    @ManyToOne
    MeetingTime meetingTime;

    @ManyToOne
    Room room;

    public Class() {
    }

    public Class(Course course) {

        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public MeetingTime getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(MeetingTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Class{" +
                ", course=" + course.getId() +
                ", instructor=" + instructor.getName() +
                ", meetingTime=" + meetingTime.getId() +
                ", room=" + room.getNumber() +
                '}';
    }
}
