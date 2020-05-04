package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.repository.InstructorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class InMemoryInstructorRepository extends InMemoryBaseRepository implements InstructorRepository {

    @Override
    public void addInstructor(final Instructor instructor) {
            packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
                @Override
                public void executeTransaction(EntityManager entityManager) {
                    entityManager.persist(instructor);
                }
            });

    }
}
