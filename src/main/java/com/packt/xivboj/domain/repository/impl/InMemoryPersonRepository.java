package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.PersonRepository;
import com.packt.xivboj.exception.PersonNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryPersonRepository implements PersonRepository {

    List<Person> listOfPersons = new ArrayList<>();

    public InMemoryPersonRepository() {
        Person jedrzej = new Person("J1", "Jedrzej", "Menkina");
        jedrzej.setDescription("Mistrz ostatniego czternastoboju");
        jedrzej.setAge(23);

        Person dominik = new Person("D1", "Dominik ", "Rabalski");
        dominik.setDescription("Ostatnio prawie przegral");
        dominik.setAge(23);

        Person kuba = new Person("K1", "Jakub", "Weltrowski");
        kuba.setDescription("W ostatnim konkursie byl na podium");
        kuba.setAge(22);

        listOfPersons.add(jedrzej);
        listOfPersons.add(dominik);
        listOfPersons.add(kuba);
    }

    @Override
    public Person getPersonById(String personId) {
        Person personById = null;

        for (Person person : listOfPersons) {
            if (person != null && person.getNameId()!= null && personId.equals(person.getNameId())) {
                personById = person;
            }
        }

        if (personById == null) {
            throw new PersonNotFoundException(personId);
        }
        return personById;
    }

    @Override
    public List<Person> getAllPersons() {
        return listOfPersons;
    }

    @Override
    public void addPerson(Person person) {
        listOfPersons.add(person);
    }
}
