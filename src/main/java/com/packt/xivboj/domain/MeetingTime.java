package com.packt.xivboj.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MeetingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public MeetingTime() {
    }

    public MeetingTime(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
