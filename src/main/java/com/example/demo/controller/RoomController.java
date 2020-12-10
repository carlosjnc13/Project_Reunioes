package com.example.demo.controller;

import com.example.demo.dto.RoomDTO;
import com.example.demo.entity.RoomEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping ("api/v1")

public class RoomController extends IController{

    @Autowired
    private RoomService roomService;

    @PostMapping(ROOM_URL)
    public ResponseEntity<?> createRoom(@RequestBody RoomDTO room) throws BusinessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.createRoom(room.transformModel()));
    }

    @GetMapping(ROOM_URL)
    public ResponseEntity<?> getAllRooms(){
        return  ResponseEntity.status(HttpStatus.OK).body(roomService.getAllRooms());
    }

    @GetMapping(ROOM_URL_ID)
    public ResponseEntity<?> getRoomById(@PathVariable(value = "id") Long roomId) throws BusinessException {
            return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoomById(roomId));
    }

    @PutMapping(ROOM_URL_ID)
    public ResponseEntity<?> updateRoom(@PathVariable(value= "id") Long roomId, @Validated @RequestBody RoomDTO roomDTO) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.updateRoom(roomId, roomDTO.transformModel()));
    }

    @DeleteMapping(ROOM_URL_ID)
    public ResponseEntity<?> deleteRoom(@PathVariable(value = "id")Long roomId) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.deleteRoom(roomId));
    }
}
