package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

    private Long id;

    @NotNull(message = "Null Field : name" )
    @ApiModelProperty(hidden = true,example = "Participant Name")
    private String name;

    @NotNull(message = "Null Field : email" )
    @ApiModelProperty(hidden = true,example = "Default@email.com")
    private String email;

}
