
package com.example.cricket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.PlayersAchievements;
import com.example.cricket.model.TeamPlayerEntity;
import com.example.cricket.response.FiferResponse;
import com.example.cricket.response.MostWicketResponse;

public interface TeamPlayerRepository  extends JpaRepository<TeamPlayerEntity, Integer>{

    @Query(value = "SELECT * FROM team_player WHERE team_id = ?1" , nativeQuery = true)
    List<TeamPlayerEntity> findByTeamId(int teamId);

    @Query(value = "SELECT * FROM team_player WHERE player_id = ?1" , nativeQuery = true)
    Optional<TeamPlayerEntity> findByPlayerId(int playerId);
    
    @Query(value = "select * from Cricket.team_player where player_id=?1 and team_id in(select team_id from Cricket.teams where tournament_id=?2)",nativeQuery = true)
    Optional<TeamPlayerEntity> CheckPlayerForTournament(int playerId,int tournamentId);
    
    @Query(value = "SELECT team_name FROM Cricket.teams where team_id in(select team_id from Cricket.team_player where player_id=?1 and tournament_id=?2)",nativeQuery = true)
    String TeamNameByPlayerId(int playerId,int tournamentId);
    
    @Query(value = "SELECT exists( select * from Cricket.team_player where player_id=?1 and designation=\"Captain\" and team_id in(select team_id from Cricket.teams where tournament_id=?2))",nativeQuery = true)
    int CheckForCaptain(int playerId,int tournamentId);
    
    @Query(value = "SELECT p.player_id as playerid,p.five_wickets_hauls as fifers,tp.player_name as playername,t.team_name as teamname FROM Cricket.team_player p, Cricket.players tp,Cricket.teams t where  (t.team_id=p.team_id) and (tp.player_id=p.player_id) and p.five_wickets_hauls=(select max(five_wickets_hauls) from Cricket.team_player where team_id in(select team_id from Cricket.teams where tournament_id=?1)) and t.tournament_id=?1",nativeQuery = true)
    List<FiferResponse> HighestFifer(int tournamentId);
    
    @Query(value ="SELECT p.player_id as playerid,p.wickets as wickets,tp.player_name as playername,t.team_name as teamname FROM Cricket.team_player p, Cricket.players tp,Cricket.teams t where  (t.team_id=p.team_id) and (tp.player_id=p.player_id) and p.wickets=(select max(wickets) from Cricket.team_player where team_id in(select team_id from Cricket.teams where tournament_id=?1)) and t.tournament_id=?1",nativeQuery =true)
    List<MostWicketResponse> MostWickets(int tournamentId);
    
    @Query(value = "select tp.player_id as playerid,tp.five_wickets_hauls as fifers,p.player_name as playername,t.team_name as teamname from Cricket.team_player tp,Cricket.teams t,players p where tp.team_id=t.team_id and tp.player_id=p.player_id and t.tournament_id=?1 order by five_wickets_hauls desc limit 10",nativeQuery = true)
    List<FiferResponse> GetTopTenFifers(int tournamentId);
    
    @Query(value = "select tp.player_id as playerid,tp.wickets as wickets,p.player_name as playername,t.team_name as teamname from Cricket.team_player tp,Cricket.teams t,players p where tp.team_id=t.team_id and tp.player_id=p.player_id and t.tournament_id=?1 order by wickets desc limit 10",nativeQuery = true)
    List<MostWicketResponse> GetTopTenWicketTakers(int tournamentId);
    

}
