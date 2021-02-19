package com.example.cricket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.PlayerEntity;
import com.example.cricket.model.TeamPlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer>{

    @Query(value = "SELECT player_id FROM players WHERE phone_number = ?1" , nativeQuery = true)
    Optional<Integer> findByPhoneNumber(long phoneNumber);

    
    @Query(value = "select player_name from players where player_id=?" , nativeQuery = true)
    String getPlayerName(long phoneNumber);
    
    
    
    



}