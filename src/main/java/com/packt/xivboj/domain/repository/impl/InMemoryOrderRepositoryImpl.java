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

import static com.packt.xivboj.util.PrincipalUtil.getCurrentUserCartName;

@Repository
public class InMemoryOrderRepositoryImpl extends InMemoryBaseRepository  implements OrderRepository {

    @Autowired
    CartService cartService;

    public InMemoryOrderRepositoryImpl() {
    }

    public long saveOrder(final Order order) {

        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
                Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM person where username =" + "\"" + currentPrincipalName + "\"", Person.class);
                Person person = (Person) nativeQuery.getSingleResult();
                order.setPerson(person);

                List<Integer> competitionIdList = entityManager.createNativeQuery("SELECT allCartCompetition_competitionId " + "FROM" +
                        " cartcompetition" + " where cart_cartId =" + "\"" + getCurrentUserCartName() + "\"").getResultList();

                List<Competition> competitionList = new ArrayList<>();

                for (Integer competitionId : competitionIdList) {
                    competitionList.add(entityManager.find(Competition.class, competitionId));
                }

                person.setCompetitionList(competitionList);
                entityManager.merge(person);
                entityManager.persist(order);
            }
        });
        return order.getOrderId();
    }

}
