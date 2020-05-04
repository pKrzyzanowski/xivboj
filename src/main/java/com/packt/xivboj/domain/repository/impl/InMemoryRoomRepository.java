package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.RoomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class InMemoryRoomRepository extends InMemoryBaseRepository implements RoomRepository {
    @Override
    public void addRoom(final Room room) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.persist(room);
            }
        });
    }
}
