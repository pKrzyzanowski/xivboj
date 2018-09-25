package com.packt.xivboj.domain.repository.impl;


import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Order;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.OrderRepository;
import com.packt.xivboj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @Autowired
    CartService cartService;

    public InMemoryOrderRepositoryImpl() {

    }

    public long saveOrder(Order order) {


        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM person where username =" + "\"" + currentPrincipalName + "\"", Person.class);
        Person person = (Person) nativeQuery.getSingleResult();
        order.setPerson(person);

        List<Integer> competitionIdList = myEntityManager.createNativeQuery("SELECT allCartCompe_competitionId " + "FROM" +
                " cartcompetition" + " where cart_cartId =" + "\"" + currentPrincipalName + "sCart" + "\"").getResultList();

        List<Competition> competitionList = new ArrayList<>();

        for (Integer competitionId : competitionIdList) {
            competitionList.add(myEntityManager.find(Competition.class, competitionId));
        }


        person.setCompetitionList(competitionList);
        myEntityManager.merge(person);
        myEntityManager.persist(order);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        cartService.delete(order.getCart().getCartId());
        return order.getOrderId();
    }

}
