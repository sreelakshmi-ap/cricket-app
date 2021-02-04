package com.example.cricket.service;

import com.example.cricket.request.Playing;
import com.example.cricket.request.Toss;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UpdateScoreService {
    public ResponseEntity toss(Toss toss);

    public ResponseEntity startMatch(int matchId);

    public ResponseEntity batsmenList(int matchId);

    public ResponseEntity bowlerList(int matchId);

   public ResponseEntity currentPlaying(List<Playing> playingList, int matchId);
}
