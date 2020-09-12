package com.packt.xivboj.service;

import com.packt.xivboj.domain.Room;

import java.util.List;

public interface RoomService {
    void addRoom(Room room);

    Room getRoomById(int id);

    List<Room> getAllRooms();

    void delete(int roomId);
}
