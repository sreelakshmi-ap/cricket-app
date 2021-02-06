package com.example.cricket.repository;

import com.example.cricket.model.TeamScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamScoreRepository extends JpaRepository<TeamScore,Integer> {
   public TeamScore findByMatchIdAndTeamId(int matchId, int teamId);


  public   List<TeamScore> findAllByMatchId(int matchId);
}

