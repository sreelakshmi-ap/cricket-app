package com.example.cricket.repository;

import com.example.cricket.model.TeamScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamScoreRepository extends JpaRepository<TeamScore, Integer> {
	@Query(value = "SELECT * FROM Cricket.team_score where team_id=?1 and match_id=?2", nativeQuery = true)
	TeamScore findByMatchIdAndTeamId(int teamId, int matchId);

}
