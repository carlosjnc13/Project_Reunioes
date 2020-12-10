package com.example.demo.dto;
import com.example.demo.model.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTOResponse {

    private long id;
    private String name;
    private LocalDate date;
    private LocalTime startHour;
    private LocalTime endHour;
    private List<Participant> participants;


}
