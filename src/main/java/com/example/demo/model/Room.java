package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private Long id;

    private Equipment equipment;

    @NotNull(message = "Null Field : name" )
    private String name;

    @NotNull(message = "Null Field : date" )
    private LocalDate date;

    @NotNull(message = "Null Field : starHour" )
    private LocalTime startHour;

    @NotNull(message = "Null Field : endHour" )
    private LocalTime endHour;

}
