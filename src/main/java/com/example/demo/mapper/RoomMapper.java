package com.example.demo.mapper;

import com.example.demo.entity.EquipmentEntity;
import com.example.demo.entity.RoomEntity;
import com.example.demo.model.Equipment;
import com.example.demo.model.Room;

import java.util.List;
import java.util.stream.Collectors;

public class RoomMapper {

    public static RoomEntity marshall(Room model){
        return new RoomEntity(model.getId(), marshall(model.getEquipment()),model.getName(), model.getDate(), model.getStartHour(),
                model.getEndHour());
    }

    public static Room unmarshall(RoomEntity entity){
        return new Room(entity.getId(), unmarshall(entity.getEquipmentEntity()), entity.getName(),entity.getDate(),entity.getStartHour(),entity.getEndHour());
    }

    public static  List<RoomEntity> marshallRoom(List<Room> listRoom){
        return listRoom.stream().map(  room -> marshall(room)  ).collect(Collectors.toList());
    }

    public static List<Room> unmarshallRoom(List<RoomEntity> listEntity){
        return  listEntity.stream().map( entity -> unmarshall(entity) ).collect(Collectors.toList());
    }

    public  static EquipmentEntity marshall(Equipment model){
        return new EquipmentEntity(model.getId(), model.getNome(), model.getNumSerie());
    }

    public static Equipment unmarshall(EquipmentEntity entity){
        return new Equipment(entity.getEquipmentId(), entity.getNome(), entity.getNumSerie());
    }

    public static  List<EquipmentEntity> marshall(List<Equipment> listEquipment){
        return listEquipment.stream().map( equipment -> marshall(equipment) ).collect(Collectors.toList());
    }

    public static  List<Equipment> unmarshall(List<EquipmentEntity> listEntity){
        return listEntity.stream().sequential().map( entity -> unmarshall(entity) ).collect(Collectors.toList());
    }


}
