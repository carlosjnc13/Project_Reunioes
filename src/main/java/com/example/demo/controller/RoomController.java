package com.example.demo.controller;


import com.example.demo.exception.BusinessException;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping ("api/v1")

public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId) throws BusinessException {
            return ResponseEntity.ok().body(roomService.getRoomById(roomId));
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room room) throws BusinessException {
        return roomService.createRoom(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value= "id") long roomId, @Valid @RequestBody Room roomDetails) throws BusinessException {
        return ResponseEntity.ok(roomService.updateRoom(roomId,roomDetails));
    }

    @DeleteMapping("/rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id")Long roomId) throws BusinessException {
        return roomService.deleteRoom(roomId);
    }
}
