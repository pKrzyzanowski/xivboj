package com.packt.xivboj.controller.rest;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Room;
import com.packt.xivboj.domain.repository.impl.BaseRepositoryTransaction;
import com.packt.xivboj.domain.repository.impl.InMemoryBaseRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/room")
public class RoomRestController extends InMemoryBaseRepository {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/remove/{roomId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int roomId) {
        final Room room = roomService.getRoomById(roomId);

        if (room == null) {
            throw new IllegalArgumentException(new CompetitionNotFoundException(roomId));
        }
        roomService.delete(roomId);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

}
