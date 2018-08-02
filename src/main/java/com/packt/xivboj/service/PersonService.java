package com.packt.xivboj.service;

import com.packt.xivboj.domain.Person;

import java.util.List;

public interface PersonService {
    Person getPersonById(String personId);

    List<Person> getAllPersons();

    void addPerson(Person person);
}
