package com.example.cricket.service;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.cricket.repository.PlayerRepository;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamPlayerRepository;
import com.example.cricket.repository.TeamRepo;
import com.example.cricket.response.BattingAverageResponse;
import com.example.cricket.model.PlayerEntity;
import com.example.cricket.model.Team;
import com.example.cricket.model.TeamPlayerEntity;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamPlayerRepository;

import com.example.cricket.response.BestBattingStrikeRate;
import com.example.cricket.response.BestBowlingAverageResponse;
import com.example.cricket.response.BestBowlingResponse;
import com.example.cricket.response.BestEconomy;
import com.example.cricket.response.FiferResponse;
import com.example.cricket.response.HighestScore;

import com.example.cricket.response.ListAndMessageResponse;
import com.example.cricket.response.MainResponse;
import com.example.cricket.response.MostWicketResponse;
import com.example.cricket.response.playerStatInfo;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private PlayerScoreRepository playerScoreRepository;
    
    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    
    @Autowired
    PlayerRepository playerRepository;
    
    @Autowired
    private TeamRepo teamRepo;

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

	@Override
	public ResponseEntity<?> getBesBowling(int tournamentId) {
		List<BestBowlingResponse> bestBowling=playerScoreRepository.getBestBowling(tournamentId);
		return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success",bestBowling));
	}
	

	@Override
	public ListAndMessageResponse getBestBattingAverage(int tournament_id) {
		List<String> bowlingAverage=playerScoreRepository.getBestBowlingAverage(tournament_id);

		List<BestBowlingAverageResponse> finalPlayersList = new ArrayList<>();

		
		int player_id;
		int team_id;
		Float bowling_average;
		
		
		for(String bowlingAverages:bowlingAverage) {
			String[] arr=bowlingAverages.split(",");
			player_id=Integer.parseInt(arr[0]);
			team_id = Integer.parseInt(arr[1]); 
			bowling_average=Float.parseFloat(arr[2]);
			
			
			 PlayerEntity playerDetails=playerRepository.findById(player_id).get();
			 Team teamDetails = teamRepo.getTeamDetails(tournament_id, team_id).get();
			 BestBowlingAverageResponse playerInfo = new BestBowlingAverageResponse(playerDetails.getPlayerId(),playerDetails.getPlayerName(),playerDetails.getImagePath(),
					 teamDetails.getTeamId(),teamDetails.getTeamName(),teamDetails.getTeamLogo(),
					 bowling_average);
			 finalPlayersList.add(playerInfo);
			
		}
		return new ListAndMessageResponse(finalPlayersList,HttpStatus.OK,finalPlayersList.size());
	}
    
    

	
}
