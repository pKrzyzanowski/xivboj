package com.packt.xivboj.domain.GeneticAlgorithm;

import com.packt.xivboj.domain.Data;

import java.util.ArrayList;
import java.util.List;

public class Population {
    int size;
    Data data;

    List<Schedule> schedules;

    public Population(int size,Data data) {
        this.size = size;
        this.data = data;
        schedules = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Schedule schedule = new Schedule(data);
            schedule.populateSchedule();
            schedule.updateFitness();
            schedules.add(schedule);
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
