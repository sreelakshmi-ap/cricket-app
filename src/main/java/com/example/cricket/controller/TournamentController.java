package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.Tournament;
import com.example.cricket.request.DateTimeEntry;
import com.example.cricket.response.DateTimeResponse;
import com.example.cricket.response.TournamentResponse;
import com.example.cricket.service.TournamentService;

@RestController
public class TournamentController {

	@Autowired
	TournamentService tournamentService;

	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/CancelTournament")
	public ResponseEntity<?> CancelTournament(int tournamentId) {
		return tournamentService.CancelTournament(tournamentId);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/createTournament")
	public TournamentResponse CreateTournament(@RequestBody Tournament tournament) {
		return tournamentService.CreateTournament(tournament);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addOvers")
	public TournamentResponse AddOvers(@RequestParam int tournamentId, @RequestParam int overs) {
		return tournamentService.AddOvers(tournamentId, overs);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addTimings")
	public DateTimeResponse AddTimings(@RequestParam int tournamentId, @RequestBody DateTimeEntry entry) {
		return tournamentService.AddTimings(tournamentId, entry.getStartDate(), entry.getStartOfTime(),
				entry.getEndDate(), entry.getEndOfTime());
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/viewTournament")
	public ResponseEntity<?> ViewTournamentByCode(@RequestParam String tournamentCode) {
		return tournamentService.ViewTournamentByCode(tournamentCode);
	}

	// ========

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/Knockout")
	public ResponseEntity<?> Knockout(@RequestParam int tournamentId) {
		return tournamentService.Knockout(tournamentId);
	}
	

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/FixtureForKnockoutNextRounds")
	public ResponseEntity<?> FixtureForKnockoutNextRounds(@RequestParam int tournamentId, @RequestParam int rounds) {
		return tournamentService.FixtureForKnockoutNextRounds(tournamentId, rounds);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/RegenerateKnockoutFixture")
	public ResponseEntity<?> RegenerateKnockoutFixture(@RequestParam int tournamentId) {
		return tournamentService.RegenerateKnockoutFixture(tournamentId);
	}

}
