package com.example.cricket.service;

import org.springframework.http.ResponseEntity;

public interface LiveScoreService {
   public ResponseEntity getLiveScore(int matchId);

   public ResponseEntity getScoreBoard(int matchId);
}
