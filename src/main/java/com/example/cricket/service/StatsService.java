package com.example.cricket.service;

import org.springframework.http.ResponseEntity;

public interface StatsService {
   public ResponseEntity getHighestScore(int tournamentId);

  public ResponseEntity getBestBattingStrikeRate(int tournamentId);

   public ResponseEntity getBestEconomy(int tournamentId);
   
   public ResponseEntity<?> getHighestFifer(int tournamentId);
   
   public ResponseEntity<?> getMostWickets(int tournamentId);
   
   public ResponseEntity<?> getTopTenFifers(int tournamentId);
   
   public ResponseEntity<?> getTopTenWicketTakers(int tournamentId);
   
}
