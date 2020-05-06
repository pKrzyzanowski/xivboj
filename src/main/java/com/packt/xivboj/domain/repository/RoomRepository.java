package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Room;

import java.util.List;

public interface RoomRepository {
    void addRoom(Room room);

    Room getRoomById(int id);

    List<Room> getAllRooms();

    void delete(int roomId);
}
