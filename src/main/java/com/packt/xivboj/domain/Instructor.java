package com.packt.xivboj.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Instructor")
@Table(name = "Instructor")
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    String name;

    int[] instructorAvailability;

    public Instructor() {
    }

    public Instructor(String name, int[] instructorAvailability) {
        this.name = name;
        this.instructorAvailability = instructorAvailability;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getInstructorAvailability() {
        return instructorAvailability;
    }

    public void setInstructorAvailability(int[] instructorAvailability) {
        this.instructorAvailability = instructorAvailability;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                '}';
    }
}
