package com.example.demo.model;

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

    @NotNull(message = "Null Field : name" )
    private String name;

    @NotNull(message = "Null Field : email" )
    private String email;

    List<Room> roomList;

}
