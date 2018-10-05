package com.packt.xivboj.domain.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class InMemoryBaseRepository {

    protected EntityManagerFactory entityManagerFactory;

    protected void packIntoEntityManagerTransaction(BaseRepositoryTransaction baseRepositoryTransaction) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        baseRepositoryTransaction.executeTransaction(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
