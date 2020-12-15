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
    public ResponseEntity<?> createParticipant(@RequestBody Participant participant){
        return ResponseEntity.status(HttpStatus.CREATED).body(participantService.createParticipant(participant));
    }

    @GetMapping(PARTICIPANT_URL)
    public List<Participant> getAllRooms(){
        return participantService.getAllParticipants();
    }

    @GetMapping(PARTICIPANT_URL_ID)
    public ResponseEntity<Participant> getParticipantById(@PathVariable(value = "id") Long participantId) throws BusinessException {
        return ResponseEntity.ok().body(participantService.getParticipantById(participantId));
    }

    @PutMapping(PARTICIPANT_URL_ID)
    public ResponseEntity<Participant> updateParticipant(@PathVariable(value= "id") Long participantId, @Validated @RequestBody Participant participant) throws BusinessException {
        return ResponseEntity.ok(participantService.updateParticipant(participantId, participant));
    }

    @DeleteMapping(PARTICIPANT_URL_ID)
    public Map<String, Boolean> deleteParticipant(@PathVariable(value = "id")Long participantId) throws BusinessException {
        return participantService.deleteParticipant(participantId);
    }


}
