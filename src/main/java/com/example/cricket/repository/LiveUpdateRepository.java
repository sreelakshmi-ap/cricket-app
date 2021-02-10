package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.LiveUpdate;

@Repository
public interface LiveUpdateRepository  extends JpaRepository<LiveUpdate, Long>{
	
	@Query(value = "SELECT * FROM Cricket.liveupdate where match_id=?1 and bowler_id=?2", nativeQuery = true)
	List<LiveUpdate> findBowlingStatus(int matchId,int bowlerId);

}
