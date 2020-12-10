package com.example.demo.dto;

import com.example.demo.model.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDTO {

    private Long id;
    private String name;
    private String email;

    public Participant transformModel(){
        return new Participant(id,name,email);
    }

}
