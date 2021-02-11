package com.example.cricket.controller;


import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.Matchs;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.response.InningsResponse;
import com.example.cricket.response.MatchResponse;
import com.example.cricket.response.MessageResponse;
import com.example.cricket.service.MatchService;
@RestController
public class MatchController {
	
	@Autowired
	MatchService matchService;
	

	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	TournamentRepo tournamentRepo;
	

	@PostMapping("/setInnings")
	public InningsResponse setInnings(int match_id,int innings)
	{
		return matchService.setInnings(match_id, innings);
	}

	
	@GetMapping("/getAllMatchsForTournament")
	public List<MatchResponse> getAllMatchsForTournament(@RequestParam String tournament_code) {
		return matchService.getAllMatchsForTournament(tournament_code);
		
		
		
	}
	
	@GetMapping("/getAllMatchs")
	public List<MatchResponse> getAllMatchs(@RequestParam int tournament_id) {
	   return  matchService.getAllMatchs(tournament_id);
	
	
	}
	
	@PutMapping("/stopMatch")
	public MessageResponse stopMatch(@RequestParam int match_id, String reason,String end_time){
		return  matchService.stopMatch(match_id, reason, end_time);
		
	}

     
	
	
}
			
		
	





