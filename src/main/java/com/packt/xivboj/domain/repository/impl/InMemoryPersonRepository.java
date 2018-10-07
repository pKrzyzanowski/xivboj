package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.PersonRepository;
import com.packt.xivboj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.packt.xivboj.util.PrincipalUtil.getCurrentUserCartName;


@Repository
public class InMemoryPersonRepository extends InMemoryBaseRepository implements PersonRepository {

    @Autowired
    CartService cartService;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public InMemoryPersonRepository() {
    }

    @Override
    public Person getPersonById(final int personId) {
        final AtomicReference<Person> personById = new AtomicReference<>();
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                personById.set(entityManager.find(Person.class, personId));
            }
        });
        return personById.get();
    }

    @Override
    public Person getPersonByUserName(final String userName) {

        final AtomicReference<Person> personByUserName = new AtomicReference<>();
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                try {
                    personByUserName.set((Person) entityManager.createNativeQuery("SELECT * FROM" +
                            " person where username =" + "\"" + userName + "\"", Person.class).getSingleResult());
                } catch (NoResultException e) {
                }

            }
        });
        return personByUserName.get();
    }


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
    public void addPerson(final Person person) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.persist(person);
            }
        });
    }

    @Override
    public Integer getCurrentPersonId() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer userId = (Integer) myEntityManager.createNativeQuery("SELECT nameId " + "FROM" +
                " person where username =" + "\"" + userName + "\"").getSingleResult();
        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return userId;
    }

    @Override
    public String getPersonName() {
        final AtomicReference<String> personName = new AtomicReference<>();
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                Query nativeQuery = entityManager.createNativeQuery("SELECT name FROM person where username = " + "\""
                        + SecurityContextHolder.getContext().getAuthentication().getName() + "\"");
                personName.set((String) nativeQuery.getSingleResult());
            }
        });
        return personName.get();
    }


}
