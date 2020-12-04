package com.example.demo.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

public class Room {

    private Long id;

    @NotNull(message = "Null Field : name" )
    private String name;

    @NotNull(message = "Null Field : date" )
    private LocalDate date;

    @NotNull(message = "Null Field : starHour" )
    private LocalTime startHour;

    @NotNull(message = "Null Field : endHour" )
    private LocalTime endHour;

    public Room(Long id,String name,LocalDate date,LocalTime startHour,LocalTime endHour) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }
}
