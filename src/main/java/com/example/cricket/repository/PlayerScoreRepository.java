package com.example.cricket.repository;

import com.example.cricket.model.PlayerScore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore,Integer> {

import com.example.cricket.response.Batsmen;
import com.example.cricket.response.Bowler;
import com.example.cricket.response.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Integer> {

    @Query(value = "SELECT x.player_name as playerName,p.player_id as id from Cricket.players x ,Cricket.player_score p, Cricket.team_score t where t.batting_order=?2 and t.match_id=?1 and p.match_id=?1 and p.team_id=t.team_id and x.player_id=p.player_id", nativeQuery = true)
    List<Players> findAllPlayer(int matchId, boolean b);


    PlayerScore findByPlayerIdAndMatchId(int playerId, int matchId);

    @Query(value = "SELECT x.player_name as playerName,p.player_id as id from Cricket.players x ,Cricket.player_score p, Cricket.team_score t where t.batting_order=?2 and t.match_id=?1 and p.match_id=?1 and p.batsmen_out=0 and p.team_id=t.team_id and x.player_id=p.player_id", nativeQuery = true)
    List<Players> findAllBatsmen(int matchId, boolean b);

    @Query(value = "select x.player_name as playerName,p.on_crease as onCrease ,p.player_id as Id,p.run_scored as runScored,p.ball_faced as ballFaced,p.batsmen_sr as batsmenSr,p.no_of_fours as noOfFours,p.no_of_sixes as noOfSixes from Cricket.player_score p,Cricket.players x where p.batting=1 and p.batsmen_out=0 and x.player_id=p.player_id and p.match_id=?1 and p.team_id=?2", nativeQuery = true)
    List<Batsmen> findPlayingBatsmen(int matchId, int teamId);

    @Query(value = "select x.player_name as playerName,p.economy_rate as economyRate ,p.player_id as Id,p.runs as runs,p.wickets as wickets,p.no_of_maidens as noOfMaidens,p.no_of_overs_bowled as noOfOversBowled from Cricket.player_score p,Cricket.players x where p.bowling=1 and p.on_crease=1 and x.player_id=p.player_id and p.match_id=?1 and p.team_id=?2", nativeQuery = true)
    List<Bowler> findPlayingBowler(int matchId, int teamId);

}
