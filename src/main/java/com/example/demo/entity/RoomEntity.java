package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @Column(name = "startHour")
    private LocalTime startHour;

    @NotNull(message = "Null Field : endHour" )
    @Column(name = "endHour")
    private LocalTime endHour;

    @ManyToMany
    @JoinTable(name="room_Participants", joinColumns = { @JoinColumn(name="meetingroom_id") }, inverseJoinColumns = { @JoinColumn(name="participants_id")})
    private List<ParticipantEntity> participants;

}
