package com.example.cricket.service;

import java.util.*;
import java.util.stream.Collectors;

import com.example.cricket.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cricket.model.TeamPlayerEntity;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamPlayerRepository;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private PlayerScoreRepository playerScoreRepository;
    
    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    @Override
    public ResponseEntity getHighestScore(int tournamentId) {
        List<HighestScore> highestScore =playerScoreRepository.findHighestScore(tournamentId);
        return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", highestScore));
    }

    @Override
    public ResponseEntity getBestBattingStrikeRate(int tournamentId) {
        List<BestBattingStrikeRate> bestBattingStrikeRate = playerScoreRepository.findBestBattingStrikeRate(tournamentId);
        return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", bestBattingStrikeRate));
    }

    @Override
    public ResponseEntity getBestEconomy(int tournamentId) {
        List<BestEconomy> bestEconomy = playerScoreRepository.findBestEconomy(tournamentId);
        return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", bestEconomy));
    }

	@Override
	public ResponseEntity getBestBowlingStrikeRate(int tournamentId) {
    	List<BestBowlingStrikeRate> best = playerScoreRepository.findBestBowlingStrikeRate(tournamentId);
		return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success",best));
	}

	@Override
	public ResponseEntity<?> getHighestFifer(int tournamentId) {
		List<FiferResponse> highestfifer=teamPlayerRepository.HighestFifer(tournamentId);
		return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", highestfifer));
	}

	@Override
	public ResponseEntity<?> getMostWickets(int tournamentId) 
	{
		
		List<MostWicketResponse> mostWickets=teamPlayerRepository.MostWickets(tournamentId);
		return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", mostWickets));
	}

	@Override
	public ResponseEntity<?> getTopTenFifers(int tournamentId) {
		List<FiferResponse> toptenfifers=teamPlayerRepository.GetTopTenFifers(tournamentId);
		return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", toptenfifers));
	}

	@Override
	public ResponseEntity<?> getTopTenWicketTakers(int tournamentId) {
		List<MostWicketResponse> toptenwickettakers=teamPlayerRepository.GetTopTenWicketTakers(tournamentId);
		return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", toptenwickettakers));
	}
	
	
}
