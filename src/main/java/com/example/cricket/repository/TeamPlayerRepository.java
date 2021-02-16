
package com.example.cricket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.PlayersAchievements;
import com.example.cricket.model.TeamPlayerEntity;


public interface TeamPlayerRepository extends JpaRepository<TeamPlayerEntity, Integer> {

	@Query(value = "SELECT * FROM team_player WHERE team_id = ?1", nativeQuery = true)
	List<TeamPlayerEntity> findByTeamId(int teamId);

	@Query(value = "SELECT * FROM team_player WHERE player_id = ?1", nativeQuery = true)
	Optional<TeamPlayerEntity> findByPlayerId(int playerId);

	@Query(value = "select * from Cricket.team_player where player_id=?1 and team_id in(select team_id from Cricket.teams where tournament_id=?2)", nativeQuery = true)
	Optional<TeamPlayerEntity> CheckPlayerForTournament(int playerId, int tournamentId);

	@Query(value = "SELECT team_name FROM Cricket.teams where team_id in(select team_id from Cricket.team_player where player_id=?1 and tournament_id=?2)", nativeQuery = true)
	String TeamNameByPlayerId(int playerId, int tournamentId);

	@Query(value = "SELECT exists( select * from Cricket.team_player where player_id=?1 and designation=\"Captain\" and team_id in(select team_id from Cricket.teams where tournament_id=?2))", nativeQuery = true)
	int CheckForCaptain(int playerId, int tournamentId);

	@Query(value = "SELECT * FROM Cricket.team_player where team_id in (SELECT t.team_id FROM teams t where t.tournament_id=?1)", nativeQuery = true)
	List<TeamPlayerEntity> listOfPlayersOfTournament(int tournamentId);
  
  @Query(value = "select * from team_player where player_id=?1 and team_id in(select team_id from tournament where tournament_id=?2)",nativeQuery = true)
  TeamPlayerEntity getTeamPlayer(int playerId,int tournamentId);
      

}
