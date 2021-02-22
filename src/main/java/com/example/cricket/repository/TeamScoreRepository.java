package com.example.cricket.repository;

import com.example.cricket.model.TeamScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamScoreRepository extends JpaRepository<TeamScore,Integer> {
	
   @Query(value = "SELECT * FROM Cricket.team_score where match_id=?1 and team_id=?2",nativeQuery = true)
   public TeamScore findByMatchIdAndTeamId(int matchId, int teamId);
   
   @Query(value = "SELECT wickets FROM Cricket.team_score where match_id=?1 and batting_order=1",nativeQuery = true)
   public int FindWicket(int matchId);
   
   @Query(value = "SELECT runs FROM Cricket.team_score where match_id=?1 and batting_order=1",nativeQuery = true )
   public int FindTarget(int matchId);
   
   @Query(value = "SELECT runs FROM Cricket.team_score where match_id=?1 and batting_order=0",nativeQuery = true )
   public int CurrentRun(int matchId);
   
//   @Query(value = "SELECT runs FROM Cricket.team_score where match_id=?1 and batting_order=0",nativeQuery = true)
//   public int FindTarget(int matchId);
   
   @Query(value = "SELECT team_id from Cricket.team_score where batting_order=0 and match_id=?1",nativeQuery = true)
   public int GetBowlingTeamId(int matchId);
   
   


  public   List<TeamScore> findAllByMatchId(int matchId);
}

