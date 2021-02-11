package com.example.cricket.controller;


import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.Tournament;
import com.example.cricket.request.DateTimeEntry;
import com.example.cricket.response.DateTimeResponse;

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

	
	@PostMapping("/addOvers")
	public TournamentResponse AddOvers(@RequestParam int tournamentId,@RequestParam  int overs)
	{
		return tournamentService.AddOvers(tournamentId, overs);
	}
	
	@PostMapping("/addTimings")
	public DateTimeResponse AddTimings(@RequestParam int tournamentId,@RequestBody DateTimeEntry entry)
	{
		return tournamentService.AddTimings(tournamentId,entry.getStartDate(),entry.getStartOfTime(),entry.getEndDate(),entry.getEndOfTime());
	}


}
