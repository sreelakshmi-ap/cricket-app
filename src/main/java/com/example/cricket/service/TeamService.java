package com.example.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Team;
import com.example.cricket.repository.TeamRepo;
import com.example.cricket.response.TeamResponse;

@Service
public class TeamService {
	
	@Autowired
	TeamRepo teamRepo;
	
	
	public TeamResponse AddTeam(int tournamentId,Team team)
	{
		team.setTournamentId(tournamentId);
		teamRepo.save(team);
		return new TeamResponse(team,"Team Added",HttpStatus.OK);
	}
	
	

}
