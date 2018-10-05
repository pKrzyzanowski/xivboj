package com.packt.xivboj.domain.repository.impl;

import javax.persistence.EntityManager;

public interface BaseRepositoryTransaction {
    void executeTransaction(EntityManager entityManager);
}
