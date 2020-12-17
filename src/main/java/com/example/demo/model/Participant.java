package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

    private Long id;
    private String name;
    private String email;

}
