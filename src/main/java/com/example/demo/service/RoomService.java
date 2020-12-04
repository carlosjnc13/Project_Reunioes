package com.example.demo.service;

import com.example.demo.exception.BusinessException;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) throws BusinessException {

        if(room.getDate().isBefore(LocalDate.now()))
            throw new BusinessException(BusinessException.INVALID_DATE);

        if(room.getStartHour().isAfter(room.getEndHour()))
            throw new BusinessException(BusinessException.TIME_ERROR);

        if(room.getStartHour().equals(room.getEndHour()))
            throw new BusinessException(BusinessException.TIME_ERROR);

        return roomRepository.save(room);
    }
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(long roomId) throws BusinessException {

        return  roomRepository.findById(roomId)
                .orElseThrow(() -> new BusinessException(BusinessException.ROOM_NOT_FOUND+": "+roomId));
    }

    public Room updateRoom(long roomId, Room roomRequest) throws BusinessException {

        Optional<Room> room = roomRepository.findById(roomId);

        if(room.isEmpty())
            throw new BusinessException(BusinessException.ROOM_NOT_FOUND + ": " + roomId);

        if(roomRequest.getStartHour() == null)
            throw new BusinessException(BusinessException.NULL_FIELD + " :startHour");

        if(roomRequest.getEndHour() == null)
            throw new BusinessException(BusinessException.NULL_FIELD + " :endHour");

        if(roomRequest.getName() == null || roomRequest.getName() == "" )
            throw new BusinessException(BusinessException.NULL_FIELD + " :Name");

        if(roomRequest.getDate().isBefore(LocalDate.now()) || roomRequest.getDate() == null)
            throw new BusinessException(BusinessException.INVALID_DATE);

        if(roomRequest.getStartHour().isAfter(roomRequest.getEndHour()))
            throw new BusinessException(BusinessException.TIME_ERROR);

        if(roomRequest.getStartHour().equals(roomRequest.getEndHour()))
            throw new BusinessException(BusinessException.TIME_ERROR);

        Room saveRoom = room.get();
        saveRoom.setDate(roomRequest.getDate());
        saveRoom.setEndHour(roomRequest.getEndHour());
        saveRoom.setName(roomRequest.getName());
        saveRoom.setStartHour(roomRequest.getStartHour());
        return  roomRepository.save(saveRoom);
    }

    public Map<String, Boolean> deleteRoom(long roomId) throws BusinessException {
        Optional<Room> room =  roomRepository.findById(roomId);

        if(room.isEmpty())
            throw new BusinessException(BusinessException.ROOM_NOT_FOUND + ": " + roomId);

        roomRepository.delete(room.get());
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return response;
    }
}
