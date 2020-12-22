package com.example.demo.mapper;

import com.example.demo.entity.EquipmentEntity;
import com.example.demo.model.Equipment;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentMapper {

    public static EquipmentEntity marshall(Equipment model){
        return new EquipmentEntity(model.getId(), model.getName(),model.getHash(), model.getMarch(), model.getYear(), model.getCreation(), model.getDescription());
    }

    public static Equipment unmarshall(EquipmentEntity entity){
        return new Equipment(entity.getEquipmentId(), entity.getName(),entity.getHash(), entity.getMarch(), entity.getYear(), entity.getCreation(), entity.getDescription());
    }

    public static List<EquipmentEntity> marshall (List<Equipment> listEquipment){
        return listEquipment.stream().map(  equipment -> marshall(equipment)  ).collect(Collectors.toList());
    }

    public static List<Equipment> unmarshall (List<EquipmentEntity> listEntity){
        return  listEntity.stream().map( entity -> unmarshall(entity) ).collect(Collectors.toList());
    }
}
