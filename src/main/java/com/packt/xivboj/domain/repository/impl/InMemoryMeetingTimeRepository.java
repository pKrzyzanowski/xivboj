package com.packt.xivboj.domain.repository.impl;


import com.packt.xivboj.domain.MeetingTime;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.MeetingTimeRepository;
import com.packt.xivboj.domain.repository.RoomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class InMemoryMeetingTimeRepository extends InMemoryBaseRepository implements MeetingTimeRepository {
    @Override
    public void addMeetingTime(final MeetingTime meetingTime) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.persist(meetingTime);
            }
        });
    }

    @Override
    public List<MeetingTime> getAllMeetingTimes() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM meetingTime", MeetingTime.class);
        List<MeetingTime> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return resultList;
    }
}
