package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.LiveUpdate;

public interface LiveUpdateRepository extends JpaRepository<LiveUpdate, Long> {

	@Query(value = "SELECT * FROM Cricket.liveupdate where team_id=?1 and match_id=?2", nativeQuery = true)
	LiveUpdate findLiveMatch(int teamId,int matchId);
	
	@Query(value = "SELECT * FROM Cricket.liveupdate where team_id=?1 and match_id=?2 and bowler_id=?3", nativeQuery = true)
	List<LiveUpdate> findBowlingStatus(int teamId,int matchId,int bowlerId);

}
