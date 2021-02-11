package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.LiveUpdate;

import java.util.List;

@Repository
public interface LiveUpdateRepository  extends JpaRepository<LiveUpdate, Long>{
	
	@Query(value = "SELECT * FROM Cricket.liveupdate where match_id=?1 and bowler_id=?2", nativeQuery = true)
	List<LiveUpdate> findBowlingStatus(int matchId,int bowlerId);
	
	@Query(value = "select count(t1.ball_type) from Cricket.liveupdate t1 where t1.ball_type=?1 and t1.match_id=?2 and t1.team_id=?3", nativeQuery = true)
	int countOfExtras(String ballType,int matchId,int teamId);


    @Query(value = "select * from liveupdate where match_id=?1 and team_id=?2",nativeQuery = true)
  public   List<LiveUpdate> findAllByMatchIdAndTeamId(int matchId, int teamId);
}
