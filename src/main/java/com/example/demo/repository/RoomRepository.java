package com.example.demo.repository;

import com.example.demo.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity,Long> {
    List<RoomEntity> findAllByparticipantsIdEquals (Long participantId);

}
