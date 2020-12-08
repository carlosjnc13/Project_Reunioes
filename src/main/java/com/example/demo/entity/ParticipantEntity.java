package com.example.demo.entity;

import com.example.demo.model.Room;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    public ParticipantEntity() { }

    public ParticipantEntity(Long id,String name,String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString(){
        return "Participant [id=" + id+",name=" + name + ",email ="+ email +"]";

    }
}
