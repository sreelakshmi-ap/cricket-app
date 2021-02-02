package com.example.cricket.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.Team;
import com.example.cricket.model.Tournament;
import com.example.cricket.model.Umpires;
import com.example.cricket.repository.GroundRepository;
import com.example.cricket.repository.TeamRepo;
import com.example.cricket.repository.TournamentGroundRepository;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.repository.Tournament_umpire_mapping_Repository;
import com.example.cricket.repository.UmpiresRepository;
import com.example.cricket.response.OverviewResponse;


@RestController
@RequestMapping("/test")
public class OverviewController {
	@Autowired
	TournamentRepo tournamentRepo;

	@Autowired
	TeamRepo teamRepo;

	@Autowired
	TournamentGroundRepository tournamentGroundRepository;

	@Autowired
	GroundRepository groundRepository;

	@Autowired
	Tournament_umpire_mapping_Repository tournament_umpire_mapping_Repository;

	@Autowired
	UmpiresRepository umpiresRepository;

	@GetMapping("/Overview")
	public OverviewResponse getOverview(@RequestParam int tournamentId) {
		List<Team> teams = teamRepo.findAllByTournamentId(tournamentId);
		int Overs = tournamentRepo.findOversByTournamentId(tournamentId);

		List<Integer> groundList = tournamentGroundRepository.findGroundsByTournamentId(tournamentId);
		List<GroundEntity> grounds = new ArrayList<>();
		for (Integer i : groundList) {
			GroundEntity ground = groundRepository.findGroundById(i);
			grounds.add(ground);
		}

		List<Umpires> umpires = new ArrayList<>();
		List<Integer> umpireList = tournament_umpire_mapping_Repository.findUmpiresByTournamentId(tournamentId);
		for (Integer i : umpireList) {
			Umpires umpire = umpiresRepository.findUmpiresById(i);
			umpires.add(umpire);
		}
		Optional<Tournament> tournament = tournamentRepo.findById(tournamentId);
		Tournament existing = tournament.get();

		LocalDate startDate = existing.getStartDate();
		LocalDate endDate = existing.getEndDate();

		LocalTime startOfTime = existing.getStartOfTime();
		LocalTime endOfTime = existing.getEndOfTime();

		return new OverviewResponse(teams, Overs, grounds, umpires, startDate, endDate, startOfTime, endOfTime);

	}
}
