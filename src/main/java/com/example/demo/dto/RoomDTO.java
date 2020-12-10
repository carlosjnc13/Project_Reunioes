package com.example.demo.dto;

import com.example.demo.model.Participant;
import com.example.demo.model.Room;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    @NotNull(message = "Null Field : name" )
    @ApiModelProperty(example = "Room name")
    private String name;

    @NotNull(message = "Null Field : date" )
    @ApiModelProperty(example = "yyyy-mm-dd")
    private LocalDate date;

    @NotNull(message = "Null Field : starHour" )
    @ApiModelProperty(example = "hh:mm:ss")
    private LocalTime startHour;

    @NotNull(message = "Null Field : endHour" )
    @ApiModelProperty(example = "hh:mm:ss")
    private LocalTime endHour;

    @NotNull(message = "Null Field: ListParticipants")
    private List<Participant> participants;

    public Room transformModel(){
        return new Room(null,name,date,startHour,endHour,participants);
    }


}
