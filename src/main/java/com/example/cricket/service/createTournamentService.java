package com.example.cricket.service;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.cricket.model.*;
import com.example.cricket.repository.*;
import com.example.cricket.response.OverviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.cricket.response.MessageResponse;
import com.example.cricket.response.UmpireResponse;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class createTournamentService {
	
	@Autowired
	Tournament_umpire_mapping_Repository repo;

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
	
	public MessageResponse addUmpireToTournament(int umpire_id,int tournament_id) {
		Tournament_umpire_mapping mapping1=repo.findUmpire(umpire_id, tournament_id);
		if(mapping1==null) {
		Tournament_umpire_mapping mapping=new Tournament_umpire_mapping();
		mapping.setTournament_id(tournament_id);
		mapping.setUmpire_id(umpire_id);
		repo.save(mapping);
		return new MessageResponse("umpire saved successfully",HttpStatus.OK);

		}
		
		else {
			return new MessageResponse("umpire already exist in the tournament",HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	public List<UmpireResponse> getAllUmpiresOfTournament(int tournamanet_id){
		List<UmpireResponse> umpireNameAndImageList = new ArrayList<>();
		List<String> umpairNameAndImage = repo.getAllUmpiresOfTournament(tournamanet_id);
		String umpire_name,image_path;
		UmpireResponse response;

		for (String umpire :umpairNameAndImage) {
			String[] umpireValues = umpire.split(",");
			umpire_name = umpireValues[0];
			image_path = umpireValues[1];
			response = new UmpireResponse(umpire_name,image_path);

			umpireNameAndImageList.add(response);

		}
		return umpireNameAndImageList;
	}


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
