package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime startHour;
    private LocalTime endHour;
    private List<Participant> participants;

}
