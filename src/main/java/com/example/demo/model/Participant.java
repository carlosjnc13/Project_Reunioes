package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class Participant {

    private Long id;

    @NotNull(message = "Null Field : name" )
    @ApiModelProperty(hidden = true)
    private String name;

    @NotNull(message = "Null Field : email" )
    @ApiModelProperty(hidden = true)
    private String email;

    public Participant(Long id,String name,String email) {
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
}
