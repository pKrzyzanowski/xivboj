package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Class;
import com.packt.xivboj.domain.repository.ClassRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class InMemoryClassRepository extends InMemoryBaseRepository implements ClassRepository {
    @Override
    public void addClass(final Class aClass) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.persist(aClass);
            }
        });
    }
}




