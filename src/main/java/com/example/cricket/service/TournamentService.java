package com.example.cricket.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.Tournament;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.TeamRepo;
import com.example.cricket.repository.TournamentGroundRepository;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.repository.Tournament_umpire_mapping_Repository;
import com.example.cricket.response.DateTimeResponse;
import com.example.cricket.response.MainResponse;
import com.example.cricket.response.TournamentResponse;
import com.example.cricket.response.ViewTournamentResponse;

@Service
public class TournamentService {

	@Autowired
	TournamentRepo tournamentRepo;

	@Autowired
	MatchRepository matchRepo;

	@Autowired
	TeamRepo teamRepo;

	@Autowired
	Tournament_umpire_mapping_Repository repo;

	@Autowired
	TournamentGroundRepository tournamentGroundRepository;

	public ResponseEntity<?> CancelTournament(int tournamentId) {
		Tournament tournament = tournamentRepo.findById(tournamentId).get();
		if (tournament != null) {
			List<Matchs> cancelledMatches = matchRepo.findTournamentsId(tournamentId);
			for (Matchs i : cancelledMatches) {
				i.setStatus("cancelled");
			}
			matchRepo.saveAll(cancelledMatches);
			tournament.setTournamentStatus("cancelled");
			tournamentRepo.save(tournament);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new MainResponse(200, "Tournament has been Cancelled", ""));

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Tournament Not Found", ""));
		}
	}

	public TournamentResponse CreateTournament(Tournament tournament) {
		String tournamentCode = generateRandomSpecialCharacters(6);
		tournament.setTournamentCode(tournamentCode);
		tournament.setTournamentStatus("Creating");
		tournamentRepo.save(tournament);
		return new TournamentResponse(tournament.getTournamentId(), tournament.getTournamentName(),
				tournament.getTournamentCode(), "Successfully Created", HttpStatus.OK);
	}

	public TournamentResponse AddOvers(int tournamentId, int overs) {
		Tournament tournament = tournamentRepo.findById(tournamentId).get();
		tournament.setOvers(overs);
		tournamentRepo.save(tournament);
		return new TournamentResponse(tournament.getTournamentId(), tournament.getTournamentName(),
				tournament.getTournamentCode(), "Overs Added", HttpStatus.OK);
	}

	public DateTimeResponse AddTimings(int tournamentId, String start_date, String start_time, String end_date,
			String end_time) {
		Tournament tournament = tournamentRepo.findById(tournamentId).get();
		LocalDate startdate = LocalDate.parse(start_date);

		LocalTime startTime = LocalTime.parse(start_time);

		LocalDate endDate = LocalDate.parse(end_date);

		LocalTime endTime = LocalTime.parse(end_time);

		System.out.println(tournament.getStartOfTime());

		tournament.setStartDate(startdate);
		tournament.setStartOfTime(startTime);
		tournament.setEndDate(endDate);
		tournament.setEndOfTime(endTime);
		tournamentRepo.save(tournament);
		System.out.println(tournament.getStartOfTime());
		return new DateTimeResponse(tournament.getTournamentId(), "Tournament Date Time Added", HttpStatus.OK);
	}

	public ResponseEntity<?> ViewTournamentByCode(String tournamentCode) {
		Optional<Tournament> tournament = tournamentRepo.findAllByTournamentCode(tournamentCode);
		if (tournament.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ViewTournamentResponse(tournament.get(), HttpStatus.OK));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Tournament Not Found", ""));

	}

	public String generateRandomSpecialCharacters(int len) {
		StringBuilder generatedOTP = new StringBuilder();
		SecureRandom secureRandom = new SecureRandom();

		try {

			secureRandom = SecureRandom.getInstance(secureRandom.getAlgorithm());

			for (int i = 0; i < len; i++) {
				generatedOTP.append(secureRandom.nextInt(9));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedOTP.toString();

	}

	// =====================================

	public ResponseEntity<?> FixtureForKnockoutNextRounds(int tournamentId, int rounds) {
		List<Integer> teams = teamRepo.getTeamForFixture(tournamentId, rounds - 1);
		int size = teams.size();
		int noOfMatches = size / 2;
		Tournament tournament = tournamentRepo.findById(tournamentId).get();
		Random random = new Random();
		int teamOne;
		int teamTwo;
		List<Integer> grounds = tournamentGroundRepository.getGroundsForMatchs(tournamentId);
		Integer[] arr = new Integer[grounds.size()];

		for (int i = 0; i < grounds.size(); i++) {
			arr[i] = grounds.get(i);
		}

		LocalDate start_date = tournamentRepo.getStartDate(tournamentId);
		LocalDate end_date = tournamentRepo.getEndDate(tournamentId);

		List<Integer> umpires = repo.getAllUmpiresforMatch(tournamentId);
		Integer[] array = new Integer[umpires.size()];

		for (int i = 0; i < umpires.size(); i++) {
			array[i] = umpires.get(i);
		}
		int r = matchRepo.CountNoOfMatches(tournamentId);
		int index = 0;
		int in = 0;
		if (tournament.getType().equalsIgnoreCase("knockout")) {
			for (int i = 0; i < noOfMatches; i++) {
				int indexOne = getRandomIntegerBetweenRange(0, size-1);
				teamOne = teams.get(indexOne);
				teams.remove(indexOne);
				size--;
				int indexTwo = getRandomIntegerBetweenRange(0, size-1);
				teamTwo = teams.get(indexTwo);
				teams.remove(indexTwo);
				size--;
				Matchs match = new Matchs();
				match.setGround_id(arr[index]);
				match.setMatch_name("match" + (r + 1));
				match.setTeam_1_id(teamOne);
				match.setTeam_2_id(teamTwo);
				match.setTournamentId(tournamentId);
				match.setMatch_date(start_date);
				match.setUmpire_1_id(array[in]);
				match.setUmpire_2_id(array[in + 1]);
				match.setStatus("Upcoming");
				matchRepo.save(match);
				r = r + 1;
				if (index == grounds.size() - 1) {
					index = 0;
				} else {
					index = index + 1;
				}
				if (in + 1 == umpires.size() - 1) {
					in = 0;
				} else {
					in = in + 1;
				}
				start_date = start_date.plusDays(1);
				if (start_date == end_date) {
					start_date = tournamentRepo.getStartDate(tournamentId);
				}
			}
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new MainResponse(200, "Knockout fixture has been created", ""));
	}

	public ResponseEntity<?> RegenerateKnockoutFixture(int tournamentId) {
		matchRepo.deleteMatch(tournamentId);
		return Knockout(tournamentId);
	}

	// ======================================

	public ResponseEntity<?> Knockout(int tournamentId) {
		List<Integer> teams = teamRepo.getTeams(tournamentId);
		int size = teams.size();
		int noOfMatches = size / 2;
		Tournament tournament = tournamentRepo.findById(tournamentId).get();
		Random random = new Random();
		int teamOne;
		int teamTwo;
		List<Integer> grounds = tournamentGroundRepository.getGroundsForMatchs(tournamentId);
		Integer[] arr = new Integer[grounds.size()];

		for (int i = 0; i < grounds.size(); i++) {
			arr[i] = grounds.get(i);
		}

		LocalDate start_date = tournamentRepo.getStartDate(tournamentId);
		LocalDate end_date = tournamentRepo.getEndDate(tournamentId);

		List<Integer> umpires = repo.getAllUmpiresforMatch(tournamentId);
		Integer[] array = new Integer[umpires.size()];

		for (int i = 0; i < umpires.size(); i++) {
			array[i] = umpires.get(i);
		}
		int r = 0;
		int index = 0;
		int in = 0;
		if (tournament.getType().equalsIgnoreCase("knockout")) {
			for (int i = 0; i < noOfMatches; i++) {
				int indexOne = getRandomIntegerBetweenRange(0, size - 1);
				System.out.println("index one==" + indexOne);
				teamOne = teams.get(indexOne);
				teams.remove(indexOne);
				size--;
				int indexTwo = getRandomIntegerBetweenRange(0, size - 1);
				System.out.println("index one==" + indexTwo);
				teamTwo = teams.get(indexTwo);
				teams.remove(indexTwo);
				size--;
				Matchs match = new Matchs();
				match.setGround_id(arr[index]);
				match.setMatch_name("match" + (r + 1));
				match.setTeam_1_id(teamOne);
				match.setTeam_2_id(teamTwo);
				match.setTournamentId(tournamentId);
				match.setMatch_date(start_date);
				match.setUmpire_1_id(array[in]);
				match.setUmpire_2_id(array[in + 1]);
				match.setStatus("Upcoming");
				matchRepo.save(match);
				r = r + 1;
				if (index == grounds.size() - 1) {
					index = 0;
				} else {
					index = index + 1;
				}
				if (in + 1 == umpires.size() - 1) {
					in = 0;
				} else {
					in = in + 1;
				}
				start_date = start_date.plusDays(1);
				if (start_date == end_date) {
					start_date = tournamentRepo.getStartDate(tournamentId);
				}
			}
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new MainResponse(200, "Knockout fixture has been created", ""));
	}

	public static int getRandomIntegerBetweenRange(int min, int max) {
		int x = (int) (Math.random() * ((max - min) + 1)) + min;
		return x;
	}

}
