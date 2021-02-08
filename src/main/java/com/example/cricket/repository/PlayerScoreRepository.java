package com.example.cricket.repository;

import com.example.cricket.model.PlayerScore;
import com.example.cricket.response.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore,Integer> {

    @Query(value = "SELECT x.player_name as playerName,p.player_id as id from Cricket.players x ,Cricket.player_score p, Cricket.team_score t where t.batting_order=?2 and t.match_id=?1 and p.match_id=?1 and p.team_id=t.team_id and x.player_id=p.player_id",nativeQuery = true)
    List<Players> findAllPlayer(int matchId, boolean b);


    PlayerScore findByPlayerIdAndMatchId(int playerId, int matchId);

    @Query(value = "SELECT x.player_name as playerName,p.player_id as id from Cricket.players x ,Cricket.player_score p, Cricket.team_score t where t.batting_order=?2 and t.match_id=?1 and p.match_id=?1 and p.batsmen_out=0 and p.team_id=t.team_id and x.player_id=p.player_id",nativeQuery = true)
    List<Players> findAllBatsmen(int matchId, boolean b);
    
    @Query(value = "SELECT * FROM Cricket.player_score where team_id=?1 and match_id=?2 and player_id=?3", nativeQuery = true)
    PlayerScore findByTeamIdAndMatchId(int teamId, int matchId, int batsmanId);
    
    
}
