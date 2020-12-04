package com.example.demo.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="meetingroom")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull(message = "Null Field : name" )
    @Column(name = "name")
    private String name;

    @NotNull(message = "Null Field : date" )
    @Column(name = "date")
    private LocalDate date;

    @NotNull(message = "Null Field : starHour" )
    @Column(name = "startHour", nullable = false)
    private LocalTime startHour;

    @NotNull(message = "Null Field : endHour" )
    @Column(name = "endHour", nullable = false)
    private LocalTime endHour;

    public RoomEntity() {

    }

    public RoomEntity(Long id, String name, LocalDate date, LocalTime startHour, LocalTime endHour) {
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

    @Override
    public String toString(){
        return "Room [id=" + id+",name=" + name + ",date ="+ date +",startHour=" +startHour +",endHour="+ endHour +"]";

    }
}
