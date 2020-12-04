package com.example.demo.service;

import com.example.demo.exception.BusinessException;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.time.LocalDate;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) throws BusinessException {

        LocalDate currentDate = LocalDate.now();

        if(room.getDate().isBefore(currentDate)){
            throw new BusinessException(BusinessException.INVALID_DATE);

        }

        return roomRepository.save(room);

    }
}
