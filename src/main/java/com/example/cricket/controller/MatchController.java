package com.example.cricket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.response.InningsResponse;
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
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/setInnings")
	public InningsResponse setInnings(int match_id,int innings)
	{
		return matchService.setInnings(match_id, innings);
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/getAllMatchsForTournament")
	public ResponseEntity<?> getAllMatchsForTournament(@RequestParam String tournament_code) {
		return matchService.getAllMatchsForTournament(tournament_code);
		
		
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAllMatchs")
	public ResponseEntity<?> getAllMatchs(@RequestParam int tournament_id) {
	   return  matchService.getAllMatchs(tournament_id);
	
	
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/stopMatch")
	public MessageResponse stopMatch(@RequestParam int match_id, String reason,String end_time,int team_1_id,
			int team_2_id,int tournament_id){
		return  matchService.stopMatch(match_id, reason, end_time,team_1_id,team_2_id,tournament_id);
		
	}
     

	
}
			
		
	





