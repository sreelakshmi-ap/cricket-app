package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {
	@Query(value = "select teams.team_id from teams where tournament_id=?",nativeQuery = true)
	public List<Integer> getTeams(int tournament_id);


	

	@Query(value = "SELECT * FROM Cricket.teams where tournament_id=?1", nativeQuery = true)
	List<Team> findAllByTournamentId(int tournamentId);
	
	@Query(value = "select team_player_id from team_player where designation=\"Captain\" and team_id=?", nativeQuery = true)
	int getTeamCaptain(int team_id);
	
	@Query(value = "SELECT city,draw_or_cancelled,losses,wins,points from teams where team_id=?", nativeQuery = true)
	List<String> getTeamInfo(int team_id);
	
	@Query(value = "SELECT count(match_id) from matchs  where status=\"Past\" and  team_2_id=?", nativeQuery = true)
	int getMatchCount1(int team_2_id);
	
	@Query(value = "SELECT count(match_id) from matchs  where status=\"Past\" and  team_1_id=?", nativeQuery = true)
	int getMatchCount2(int team_1_id);
}
