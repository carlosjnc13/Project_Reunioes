package com.example.demo.controller;
import com.example.demo.dto.ParticipantDTO;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.Participant;
import com.example.demo.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class ParticipantController extends IController{

    @Autowired
    private ParticipantService participantService;

    @PostMapping(PARTICIPANT_URL)
    public ResponseEntity<?> createParticipant(@RequestBody ParticipantDTO participantDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(participantService.createParticipant(participantDTO.transformModel()));
    }

    @GetMapping(PARTICIPANT_URL)
    public ResponseEntity<?> getAllRooms(){
        return ResponseEntity.status(HttpStatus.OK).body(participantService.getAllParticipants());
    }

    @GetMapping(PARTICIPANT_URL_ID)
    public ResponseEntity<?> getParticipantById(@PathVariable(value = "id") Long participantId) throws BusinessException {
        return ResponseEntity.ok().body(participantService.getParticipantById(participantId));
    }

    @PutMapping(PARTICIPANT_URL_ID)
    public ResponseEntity<?> updateParticipant(@PathVariable(value= "id") Long participantId, @Validated @RequestBody ParticipantDTO participantDTO) throws BusinessException {
        return ResponseEntity.ok(participantService.updateParticipant(participantId, participantDTO.transformModel()));
    }

    @DeleteMapping(PARTICIPANT_URL_ID)
    public ResponseEntity<?> deleteParticipant(@PathVariable(value = "id")Long participantId) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(participantService.deleteParticipant(participantId));
    }


}
