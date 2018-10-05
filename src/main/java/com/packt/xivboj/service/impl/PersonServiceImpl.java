package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.PersonRepository;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person getPersonById(int personId) {
        return personRepository.getPersonById(personId);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    @Override
    public void addPerson(Person person) {
        personRepository.addPerson(person);
    }
}
