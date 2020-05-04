package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.CourseRepository;
import com.packt.xivboj.domain.repository.RoomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class InMemoryCourseRepository extends InMemoryBaseRepository implements CourseRepository {
    @Override
    public void addCourse(final Course course) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.persist(course);
            }
        });
    }
}

