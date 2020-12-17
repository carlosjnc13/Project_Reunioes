package com.example.demo.service;

import com.example.demo.dto.ParticipantDTO;
import com.example.demo.entity.ParticipantEntity;
import com.example.demo.entity.RoomEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.mapper.ParticipantMapper;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.model.Participant;
import com.example.demo.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    public Participant createParticipant(Participant participant){
        return ParticipantMapper.unmarshall(participantRepository.save(ParticipantMapper.marshall(participant)));
    }
    public List<ParticipantDTO> getAllParticipants(){
        List<ParticipantDTO>responseList = ParticipantMapper.unmarshall(participantRepository.findAll())
                .stream().map( model -> new ParticipantDTO(model.getId(), model.getName(), model.getEmail())).collect(Collectors.toList());
         return responseList;
    }

    public ParticipantDTO getParticipantById(Long participantId) throws BusinessException {
        Participant model = ParticipantMapper.unmarshall(participantRepository.findById(participantId)
                .orElseThrow(() -> new BusinessException(BusinessException.PARTICIPANT_NOT_FOUND+": "+ participantId)));
        return new ParticipantDTO(model.getId(), model.getName(), model.getEmail());
    }
    public ParticipantDTO updateParticipant(Long participantId, Participant participant) throws BusinessException{
        participantRepository.findById(participantId).orElseThrow(() -> new BusinessException(BusinessException.PARTICIPANT_NOT_FOUND+": "+ participantId));
        participant.setId(participantId);
        Participant model = ParticipantMapper.unmarshall(participantRepository.save(ParticipantMapper.marshall(participant)));
        return new ParticipantDTO(model.getId(), model.getName(), model.getEmail());
    }
    public Map<String, Boolean> deleteParticipant (Long participantId) throws BusinessException {
        Optional<ParticipantEntity> entity = participantRepository.findById(participantId);

        if(entity.isEmpty())
            throw new BusinessException(BusinessException.PARTICIPANT_NOT_FOUND + ": " + participantId);

        participantRepository.deleteById(participantId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}
