package com.example.cricket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {
	@Query(value = "select teams.team_id from teams where tournament_id=?",nativeQuery = true)
	public List<Integer> getTeams(int tournament_id);
	
	@Query(value = "select * from teams where tournament_id=?1 and team_id=?2",nativeQuery = true)
	public Optional<Team> getTeamDetails(int tournament_id,int teamId);


	

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
	
	@Query(value = "SELECT count(match_id) from matchs  where status=\"Abondoned\" and  team_1_id=?", nativeQuery = true)
	int getMatchCount3(int team_1_id);
	
	@Query(value = "SELECT count(match_id) from matchs  where status=\"Abondoned\" and  team_2_id=?", nativeQuery = true)
	int getMatchCount4(int team_1_id);
	
	
	@Query(value = "select team_id,team_name,draw_or_cancelled,losses,points,wins from teams where tournament_id=?", nativeQuery = true)
	List<String> getTeamStandings(int tournament_id);
	
	@Query(value = "select t.runs,t.overs,t.match_id as match_ids,m.match_id as matchs_id from team_score t,matchs m where t.team_id=? and m.status IN ( 'Past', 'Abondoned')  and m.match_id=t.match_id", nativeQuery = true)
	List<String> getTeamRR(int team_id);
	
	@Query(value = "select runs,overs from team_score where match_id=?1 and team_id!=?2", nativeQuery = true)
	List<String> getTeamRR1(int match_id,int team_id);
	
	@Query(value = "SELECT team_id FROM Cricket.teams where tournament_id=?1 and wins=?2", nativeQuery = true)
	public List<Integer> getTeamForFixture(int tournament_id, int rounds);
	
	


}
