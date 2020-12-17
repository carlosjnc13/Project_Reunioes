package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="participants")
public class ParticipantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Null Field : name" )
    @Column(name = "name")
    private String name;

    @NotNull(message = "Null Field : name" )
    @Column(name = "email")
    private String email;

}
