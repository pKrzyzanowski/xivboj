package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.MeetingTime;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.InstructorRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


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

    @Override
    public Instructor getInstructorById(final int id) {

        final AtomicReference<Instructor> instructorById = new AtomicReference<>();

        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                try {
                    instructorById.set(entityManager.find(Instructor.class, id));
                } catch (Exception e) {
                    throw new CompetitionNotFoundException(id);
                }
            }
        });
        return instructorById.get();
    }


    @Override
    public List<Instructor> getAllInstructors() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM Instructor", Instructor.class);
        List<Instructor> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return resultList;
    }

    @Override
    public void delete(final int instructorId) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.remove(entityManager.find(Instructor.class, instructorId));
            }
        });
    }
}
