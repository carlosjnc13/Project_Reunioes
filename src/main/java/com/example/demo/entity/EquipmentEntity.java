package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "equipment")
public class EquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long equipmentId;

    @NotNull(message = "Null Field : nome" )
    @Column(name = "name")
    private String name;

    @NotNull(message = "Null Field : numSerie" )
    @Column(name = "hash")
    private String hash;

    @NotNull(message = "Null Field : march" )
    @Column(name = "march")
    private String march;

    @NotNull(message = "Null Field : year" )
    @Column(name = "year")
    private String year;

    @NotNull(message = "Null Field : creation" )
    @Column(name = "creation")
    private Date creation;

    @NotNull(message = "Null Field : description" )
    @Column(name = "description")
    private String description;
}
