
package com.example.cricket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.TeamPlayerEntity;

public interface TeamPlayerRepository  extends JpaRepository<TeamPlayerEntity, Integer>{

    @Query(value = "SELECT * FROM team_player WHERE team_id = ?1" , nativeQuery = true)
    List<TeamPlayerEntity> findByTeamId(int teamId);

    @Query(value = "SELECT * FROM team_player WHERE player_id = ?1" , nativeQuery = true)
    Optional<TeamPlayerEntity> findByPlayerId(int playerId);
}
