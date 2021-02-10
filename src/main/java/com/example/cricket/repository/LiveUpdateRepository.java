package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.LiveUpdate;

import java.util.List;

@Repository
public interface LiveUpdateRepository  extends JpaRepository<LiveUpdate, Long>{

    @Query(value = "select * from liveupdate where match_id=?1 and team_id=?2",nativeQuery = true)
  public   List<LiveUpdate> findAllByMatchIdAndTeamId(int matchId, int teamId);
}
