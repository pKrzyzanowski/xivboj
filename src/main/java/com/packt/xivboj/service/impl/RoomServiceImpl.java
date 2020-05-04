package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Instructor;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.InstructorRepository;
import com.packt.xivboj.domain.repository.RoomRepository;
import com.packt.xivboj.service.InstructorService;
import com.packt.xivboj.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl  implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void addRoom(Room room) {
        roomRepository.addRoom(room);
    }
}


