package com.example.cricket.repository;

import java.util.List;

import com.example.cricket.response.OutReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.LiveUpdate;

import java.util.List;

@Repository
public interface LiveUpdateRepository  extends JpaRepository<LiveUpdate, Long>{
	
	@Query(value = "SELECT * FROM Cricket.liveupdate where match_id=?1 and bowler_id=?2", nativeQuery = true)
	List<LiveUpdate> findBowlingStatus(int matchId,int bowlerId);

    @Query(value = "select * from liveupdate where match_id=?1 and team_id=?2",nativeQuery = true)
  public   List<LiveUpdate> findAllByMatchIdAndTeamId(int matchId, int teamId);

    @Query(value = "select p.player_name as fielderName,l.wicket_reason as wicketReason from Cricket.liveupdate l ,Cricket.players p where l.match_id=?1 and l.team_id=?2 and l.batsman_id=?3 and l.batsman_out=1 and p.player_id=l.fielder_id",nativeQuery = true)
    public OutReason findOutReason(int matchId, int teamId, int id);
}
