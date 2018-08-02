package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Person;

import java.util.List;

public interface PersonRepository {
    Person getPersonById(String personId);

    List<Person> getAllPersons();

    void addPerson(Person person);
}
