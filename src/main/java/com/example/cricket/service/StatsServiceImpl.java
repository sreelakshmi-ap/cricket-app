package com.example.cricket.service;

import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.response.BestBattingStrikeRate;
import com.example.cricket.response.BestEconomy;
import com.example.cricket.response.HighestScore;
import com.example.cricket.response.MainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private PlayerScoreRepository playerScoreRepository;

    @Override
    public ResponseEntity getHighestScore(int tournamentId) {
        HighestScore highestScore =playerScoreRepository.findHighestScore(tournamentId);
        return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", highestScore));
    }

    @Override
    public ResponseEntity getBestBattingStrikeRate(int tournamentId) {
        BestBattingStrikeRate bestBattingStrikeRate = playerScoreRepository.findBestBattingStrikeRate(tournamentId);
        return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", bestBattingStrikeRate));
    }

    @Override
    public ResponseEntity getBestEconomy(int tournamentId) {
        BestEconomy bestEconomy = playerScoreRepository.findBestEconomy(tournamentId);
        return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", bestEconomy));
    }
}
