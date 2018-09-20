package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.PersonRepository;
import com.packt.xivboj.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryPersonRepository implements PersonRepository {

//    @Autowired
//    EntityManagerFactory entityManagerFactory;
//    @Autowired
//    EntityManager myEntityManager;
//
//    @Bean
//    EntityManager myEntityManager() {
//        return entityManagerFactory.createEntityManager();
//    }

    @PersistenceContext(unitName = "mybase")
    EntityManager myEntityManager;

   private  List<Person> listOfPersons = new ArrayList<>();

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
    @Transactional
    public Person getPersonById(String personId) {
        Person personById = null;

//        myEntityManager.getTransaction().begin();
        personById= myEntityManager.find(Person.class, personId);
//        myEntityManager.getTransaction().commit();

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
