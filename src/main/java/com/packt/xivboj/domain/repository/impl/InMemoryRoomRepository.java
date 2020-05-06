package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.*;
import com.packt.xivboj.domain.repository.RoomRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.packt.xivboj.util.PrincipalUtil.getCurrentUserCartName;


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

    @Override
    public Room getRoomById(final int id) {

        final AtomicReference<Room> roomById = new AtomicReference<>();

        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                try {
                    roomById.set(entityManager.find(Room.class, id));
                } catch (Exception e) {
                    throw new CompetitionNotFoundException(id);
                }
            }
        });
        return roomById.get();
    }

    @Override
    public List<Room> getAllRooms() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM room", Room.class);
        List<Room> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return resultList;
    }

    @Override
    public void delete(final int roomId) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.remove(entityManager.find(Room.class, roomId));
            }
        });
    }
}
