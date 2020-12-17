package com.example.demo.service;

import com.example.demo.dto.RoomDTO;
import com.example.demo.dto.RoomDTOResponse;
import com.example.demo.entity.ParticipantEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.entity.RoomEntity;
import com.example.demo.mapper.ParticipantMapper;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.model.Participant;
import com.example.demo.model.Room;
import com.example.demo.repository.ParticipantRepository;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    ParticipantService participantService;

    public RoomDTOResponse createRoom(Room room) throws BusinessException {
        scheduleValidation(room);
        List<Participant> participantList = new ArrayList<>();

        for(Participant p : room.getParticipants())
            participantList.add(ParticipantMapper.unmarshall(participantRepository.findById(p.getId()).get()));

        Room repositoryResponse = RoomMapper.unmarshall(roomRepository.save(RoomMapper.marshall(room)));
        return new RoomDTOResponse(repositoryResponse.getId(), repositoryResponse.getName(), repositoryResponse.getDate(),repositoryResponse.getStartHour(),repositoryResponse.getEndHour(), participantList);

    }

    public  List<RoomDTOResponse> getAllRooms(){
        List<RoomDTOResponse> roomDTOResponseList = RoomMapper.unmarshall(roomRepository.findAll())
                .stream().map( room -> new RoomDTOResponse(room.getId(), room.getName(), room.getDate(), room.getStartHour(), room.getEndHour(), room.getParticipants())).collect(Collectors.toList());
        return roomDTOResponseList;
    }

    public RoomDTOResponse getRoomById(Long roomId) throws BusinessException {
        Room repositoryResponse = RoomMapper.unmarshall(roomRepository.findById(roomId)
                .orElseThrow(() -> new BusinessException(BusinessException.ROOM_NOT_FOUND+": "+roomId)));
        return new RoomDTOResponse(repositoryResponse.getId(), repositoryResponse.getName(), repositoryResponse.getDate(), repositoryResponse.getStartHour(), repositoryResponse.getEndHour(),repositoryResponse.getParticipants());
    }

    public RoomDTOResponse updateRoom(Long roomId, Room room) throws BusinessException {
        scheduleValidation(room);
        roomRepository.findById(roomId).orElseThrow(() -> new BusinessException(BusinessException.ROOM_NOT_FOUND + ": " + roomId));
        room.setId(roomId);
        Room repositoryResponse = RoomMapper.unmarshall(roomRepository.save(RoomMapper.marshall(room)));
        return new RoomDTOResponse(repositoryResponse.getId(), repositoryResponse.getName(), repositoryResponse.getDate(),repositoryResponse.getStartHour(),repositoryResponse.getEndHour(), repositoryResponse.getParticipants());
    }

    public Map<String, Boolean> deleteRoom(Long roomId) throws BusinessException {
        Optional<RoomEntity> room =  roomRepository.findById(roomId);

        if(room.isEmpty())
            throw new BusinessException(BusinessException.ROOM_NOT_FOUND + ": " + roomId);

        roomRepository.delete(room.get());
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return response;
    }

    private void scheduleValidation(Room roomEntity) throws BusinessException {
        if(roomEntity.getDate().isBefore(LocalDate.now()))
            throw new BusinessException(BusinessException.INVALID_DATE);

        if(roomEntity.getStartHour().isAfter(roomEntity.getEndHour()))
            throw new BusinessException(BusinessException.TIME_ERROR);

        if(roomEntity.getStartHour().equals(roomEntity.getEndHour()))
            throw new BusinessException(BusinessException.TIME_ERROR);
    }
    public List<RoomDTOResponse> getRoomsByParticipantId(Long participantId){
        List<RoomEntity> entityList = roomRepository.findAllByparticipantsIdEquals(participantId);
        List<RoomDTOResponse> responseList = entityList.stream().map( entity -> new RoomDTOResponse(entity.getId(), entity.getName(), entity.getDate(), entity.getStartHour(),
        entity.getEndHour(), ParticipantMapper.unmarshall(entity.getParticipants()))).collect(Collectors.toList());
        return responseList;
    }
}
