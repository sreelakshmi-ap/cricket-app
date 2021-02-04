package com.example.cricket.service;

import com.example.cricket.request.Toss;
import org.springframework.http.ResponseEntity;

public interface UpdateScoreService {
  public   ResponseEntity toss(Toss toss);

    public ResponseEntity startMatch(int matchId);
}
