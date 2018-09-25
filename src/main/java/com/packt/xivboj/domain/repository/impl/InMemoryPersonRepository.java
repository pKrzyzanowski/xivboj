package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.PersonRepository;
import com.packt.xivboj.exception.PersonNotFoundException;
import com.packt.xivboj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryPersonRepository implements PersonRepository {

    @Autowired
    CartService cartService;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public InMemoryPersonRepository() {

    }

    @Override
//    @Transactional
    public Person getPersonById(int personId) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Person personById = myEntityManager.find(Person.class, personId);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return personById;
//        if (personById == null) {
//            throw new PersonNotFoundException(personId);
//        }
    }
//    @Transactional
    @Override
    public List<Person> getAllPersons() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM person", Person.class);
        List<Person> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return resultList;
    }

    @Override
//    @Transactional
    public void addPerson(Person person) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        myEntityManager.persist(person);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        //wraz z nowa osba tworzy sie nowa karta
        Cart cart = new Cart();
        cart.setCartId(person.getName() + "sCart");
        person.setCart(cart);
        cart.setPerson(person);
        cartService.create(cart);

    }
}
