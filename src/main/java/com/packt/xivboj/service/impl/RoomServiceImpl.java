package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.InstructorRepository;
import com.packt.xivboj.domain.repository.RoomRepository;
import com.packt.xivboj.domain.repository.impl.BaseRepositoryTransaction;
import com.packt.xivboj.service.InstructorService;
import com.packt.xivboj.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void addRoom(Room room) {
        roomRepository.addRoom(room);
    }

    @Override
    public Room getRoomById(int id) {
        return roomRepository.getRoomById(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public void delete(final int roomId) {
        roomRepository.delete(roomId);
    }
}


