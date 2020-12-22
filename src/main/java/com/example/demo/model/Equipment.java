package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {

    private Long id;
    private String name;
    private String hash;
    private String march;
    private String year;
    private Date creation;
    private String description;
}
