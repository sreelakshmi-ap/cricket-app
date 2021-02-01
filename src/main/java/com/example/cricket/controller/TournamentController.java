package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.Tournament;
import com.example.cricket.response.TournamentResponse;
import com.example.cricket.service.TournamentService;

@RestController
public class TournamentController {
	
	@Autowired
	TournamentService tournamentService;
	
	@PostMapping("/createTournament")
	public TournamentResponse CreateTournament(@RequestBody Tournament tournament)
	{
		return tournamentService.CreateTournament(tournament);
	}

}
