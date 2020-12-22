package com.example.demo.mapper;

import com.example.demo.entity.EquipmentEntity;
import com.example.demo.entity.ParticipantEntity;
import com.example.demo.entity.RoomEntity;
import com.example.demo.model.Equipment;
import com.example.demo.model.Participant;
import com.example.demo.model.Room;

import java.util.List;
import java.util.stream.Collectors;

public class RoomMapper {

    public static RoomEntity marshall(Room model){
        return new RoomEntity(model.getId(), model.getName(),model.getDate(),model.getStartHour(),model.getEndHour(),marshallEquip(model.getEquipment()), model.getParticipants()
                .stream().map( Participant  ->  new ParticipantEntity(Participant.getId(), Participant.getName(), Participant.getEmail())).collect(Collectors.toList()));
    }

    public static Room unmarshall(RoomEntity entity){
        return new Room(entity.getId(), entity.getName(),entity.getDate(),entity.getStartHour(),entity.getEndHour(),unmarshallEquip(entity.getEquipment()), entity.getParticipants()
                .stream().map( ParticipantEntity  ->  new Participant(ParticipantEntity.getId(), ParticipantEntity.getName(), ParticipantEntity.getEmail())).collect(Collectors.toList()));
    }

    public static  List<RoomEntity> marshall (List<Room> listRoom){
        return listRoom.stream().map(  room -> marshall(room)  ).collect(Collectors.toList());
    }
    public static List<Room> unmarshall (List<RoomEntity> listEntity){
        return  listEntity.stream().map( entity -> unmarshall(entity) ).collect(Collectors.toList());
    }

    public  static EquipmentEntity marshallEquip(Equipment model){
        return new EquipmentEntity(model.getId(), model.getName(), model.getHash(), model.getMarch(), model.getYear(), model.getCreation(), model.getDescription());
    }

    public static Equipment unmarshallEquip(EquipmentEntity entity){
        return new Equipment(entity.getEquipmentId(), entity.getName(), entity.getHash(), entity.getMarch(), entity.getYear(), entity.getCreation(), entity.getDescription());
    }

    public static  List<EquipmentEntity> marshallEquip(List<Equipment> listEquipment){
        return listEquipment.stream().map( equipment -> marshallEquip(equipment) ).collect(Collectors.toList());
    }

    public static  List<Equipment> unmarshallEquip(List<EquipmentEntity> listEntity){
        return listEntity.stream().sequential().map( entity -> unmarshallEquip(entity) ).collect(Collectors.toList());
    }

}
