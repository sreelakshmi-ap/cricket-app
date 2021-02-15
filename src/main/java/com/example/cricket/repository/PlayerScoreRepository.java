package com.example.cricket.repository;

import com.example.cricket.model.PlayerScore;

import com.example.cricket.response.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Integer> {

    @Query(value = "SELECT x.player_name as playerName,p.player_id as id from Cricket.players x ,Cricket.player_score p, Cricket.team_score t where t.batting_order=?2 and t.match_id=?1 and p.match_id=?1 and p.team_id=t.team_id and x.player_id=p.player_id", nativeQuery = true)
    List<Players> findAllPlayer(int matchId, boolean b);


    PlayerScore findByPlayerIdAndMatchId(int playerId, int matchId);

    @Query(value = "SELECT x.player_name as playerName,p.player_id as id from Cricket.players x ,Cricket.player_score p, Cricket.team_score t where t.batting_order=?2 and t.match_id=?1 and p.match_id=?1 and p.batsmen_out=0 and p.team_id=t.team_id and x.player_id=p.player_id", nativeQuery = true)
    List<Players> findAllBatsmen(int matchId, boolean b);

    
    @Query(value = "SELECT * FROM Cricket.player_score where match_id=?1 and team_id=?2 and player_id=?3",nativeQuery = true)
    PlayerScore findByTeamIdAndMatchId(int matchId,int teamId,int playerId);
    
    @Query(value = "SELECT * FROM Cricket.player_score where match_id=?1 and batsmen_out=0 and batting=1 and team_id=?2 and on_crease=0",nativeQuery = true)
    PlayerScore ChangeCrease(int matchId,int teamId);


    @Query(value = "select x.player_name as playerName,p.on_crease as onCrease ,p.player_id as Id,p.run_scored as runScored,p.ball_faced as ballFaced,p.batsmen_sr as batsmenSr,p.no_of_fours as noOfFours,p.no_of_sixes as noOfSixes from Cricket.player_score p,Cricket.players x where p.batting=1 and p.batsmen_out=0 and x.player_id=p.player_id and p.match_id=?1 and p.team_id=?2", nativeQuery = true)
    List<Batsmen> findPlayingBatsmen(int matchId, int teamId);

    @Query(value = "select x.player_name as playerName,p.economy_rate as economyRate ,p.player_id as Id,p.runs as runs,p.wickets as wickets,p.no_of_maidens as noOfMaidens,p.no_of_overs_bowled as noOfOversBowled from Cricket.player_score p,Cricket.players x where p.bowling=1 and p.on_crease=1 and x.player_id=p.player_id and p.match_id=?1 and p.team_id=?2", nativeQuery = true)
    List<Bowler> findPlayingBowler(int matchId, int teamId);

    @Query(value = "select x.player_name as playerName,p.on_crease as onCrease ,p.player_id as Id,p.run_scored as runScored,p.ball_faced as ballFaced,p.batsmen_sr as batsmenSr,p.no_of_fours as noOfFours,p.no_of_sixes as noOfSixes,p.batsmen_out as batsmanOut from Cricket.player_score p,Cricket.players x where p.batting=1  and x.player_id=p.player_id and p.match_id=?1 and p.team_id=?2",nativeQuery = true)
    List<Batsman> findAllBatsmen(int matchId, int teamId);

    @Query(value = "select x.player_name as playerName,p.economy_rate as economyRate ,p.player_id as Id,p.runs as runs,p.wickets as wickets,p.no_of_maidens as noOfMaidens,p.no_of_overs_bowled as noOfOversBowled from Cricket.player_score p,Cricket.players x where p.bowling=1  and x.player_id=p.player_id and p.match_id=?1 and p.team_id=?2", nativeQuery = true)
    List<Bowler> findALLBowler(int matchId, int teamId);
    
    @Query(value = "SELECT sum(run_scored) as runs,count(match_id) as matches,sum(wickets) as wickets FROM Cricket.player_score where player_id=?1 and match_id in(select match_id from Cricket.matchs where tournament_id=?2)",nativeQuery = true)
    PlayerScoreInfo getPlayerScoreInfo(int playerId,int tournamentId);

    @Query(value = "select p.player_name as playerName, x.player_id as Id,max(x.run_scored) as highestScore FROM Cricket.player_score x ,Cricket.players p where p.player_id=x.player_id and  x.match_id in (select match_id from Cricket.matchs  where tournament_id=?1)",nativeQuery = true)
    HighestScore findHighestScore(int tournamentId);

    @Query(value = "select p.player_name as playerName, x.player_id as Id,max(x.batsmen_sr) as bestBattingStrikeRate FROM Cricket.player_score x ,Cricket.players p where p.player_id=x.player_id and  x.match_id in (select match_id from Cricket.matchs  where tournament_id=?1)",nativeQuery = true)
    BestBattingStrikeRate findBestBattingStrikeRate(int tournamentId);

    @Query(value = "select p.player_name as playerName, x.player_id as Id,max(x.economy_rate) as bestEconomy FROM Cricket.player_score x ,Cricket.players p where p.player_id=x.player_id and  x.match_id in (select match_id from Cricket.matchs  where tournament_id=?1)",nativeQuery = true)
    BestEconomy findBestEconomy(int tournamentId);
}
