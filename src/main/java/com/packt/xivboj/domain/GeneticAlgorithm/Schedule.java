package com.packt.xivboj.domain.GeneticAlgorithm;


import com.packt.xivboj.domain.Class;
import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.Data;

import java.util.ArrayList;
import java.util.List;

public class Schedule implements Comparable<Schedule> {
    Data data;
    private List<Class> classes = new ArrayList<>();
    int numOfConflicts;
    double fitness;
    int classNumber;
    boolean isFitnessChanged;

    public Schedule(Data data) {
        this.data = data;

    }

    public void updateFitness() {
        this.numOfConflicts = 0;
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getRoom().getSeatingCapacity() < classes.get(i).getCourse().getMaxNumberOfStudents())
                numOfConflicts++;
//            for (int j = 0; j < classes.size(); j++) {
            for (int j = i; j < classes.size(); j++) {
                //tutaj dac wlasnie kidy sie daje liczbe konfliktow
                if (classes.get(i).getMeetingTime() == classes.get(j).getMeetingTime() && classes.get(i).getId() != classes.get(j).getId()) {
                    if (classes.get(i).getRoom() == classes.get(j).getRoom()) numOfConflicts++;
                    if (classes.get(i).getInstructor() == classes.get(j).getInstructor()) numOfConflicts++;
                    if (classes.get(i).getCourse() == classes.get(j).getCourse()) numOfConflicts++;
                    if (!classes.get(j).getCourse().getInstructors().contains(classes.get(j).getInstructor()))
                        numOfConflicts++;
                }
            }
        }
        fitness = 1 / ((double) numOfConflicts + 1);
    }

    void populateSchedule() {
        List<Course> courses;
        courses = data.getCourses();
        for (Course course : courses) {
            for (int i = 0; i < course.getNumberOfHours(); i++) {
                Class newClass = new Class(course);
                classNumber++;
                newClass.setMeetingTime(data.getMeetingTimes().get((int) (Math.random() * data.getMeetingTimes().size() % data.getMeetingTimes().size())));
                newClass.setRoom(data.getRooms().get((int) (Math.random() * data.getRooms().size() % data.getRooms().size())));
                newClass.setInstructor(course.getInstructors().get((int) (Math.random() * course.getInstructors().size() % course.getInstructors().size())));
                classes.add(newClass);
            }
        }
    }


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public int getNumOfConflicts() {
        return numOfConflicts;
    }

    public void setNumOfConflicts(int numOfConflicts) {
        this.numOfConflicts = numOfConflicts;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public boolean isFitnessChanged() {
        return isFitnessChanged;
    }

    public void setFitnessChanged(boolean fitnessChanged) {
        isFitnessChanged = fitnessChanged;
    }

    @Override
    public int compareTo(Schedule schedule) {
        int isFitnessBigger = -1;
        if (numOfConflicts > schedule.getNumOfConflicts()) isFitnessBigger = 1;
        return isFitnessBigger;
    }
}
