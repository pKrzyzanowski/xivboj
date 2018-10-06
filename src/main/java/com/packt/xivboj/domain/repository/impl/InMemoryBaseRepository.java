package com.packt.xivboj.domain.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class InMemoryBaseRepository {

    @PersistenceUnit
    protected EntityManagerFactory entityManagerFactory;

    protected void packIntoEntityManagerTransaction(BaseRepositoryTransaction baseRepositoryTransaction) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        baseRepositoryTransaction.executeTransaction(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
