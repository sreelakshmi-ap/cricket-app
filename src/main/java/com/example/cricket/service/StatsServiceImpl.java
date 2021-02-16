package com.example.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cricket.model.TeamPlayerEntity;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamPlayerRepository;
import com.example.cricket.response.BestBattingStrikeRate;
import com.example.cricket.response.BestEconomy;
import com.example.cricket.response.FiferResponse;
import com.example.cricket.response.HighestScore;
import com.example.cricket.response.MainResponse;
import com.example.cricket.response.MostWicketResponse;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private PlayerScoreRepository playerScoreRepository;
    
    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

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
