package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.CourseRepository;
import com.packt.xivboj.domain.repository.RoomRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    @Override
    public List<Course> getAllCourses() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM course", Course.class);
        List<Course> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return resultList;
    }

    @Override
    public Course getCourseById(final int id) {

        final AtomicReference<Course> courseById = new AtomicReference<>();

        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                try {
                    courseById.set(entityManager.find(Course.class, id));
                } catch (Exception e) {
                    throw new CompetitionNotFoundException(id);
                }
            }
        });
        return courseById.get();
    }
    @Override
    public void delete(final int courseId) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.remove(entityManager.find(Course.class, courseId));
            }
        });
    }
}

