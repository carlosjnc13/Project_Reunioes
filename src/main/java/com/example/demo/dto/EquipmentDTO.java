package com.example.demo.dto;

import com.example.demo.model.Equipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {

    private Long id;
    private String name;
    private String hash;
    private String march;
    private String year;
    private Date creation;
    private String description;

    public Equipment transformModel(){
        return new Equipment(id, name, hash, march, year, creation, description);
    }
}
