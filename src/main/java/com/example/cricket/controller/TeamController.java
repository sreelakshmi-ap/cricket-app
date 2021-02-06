package com.example.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.Team;
import com.example.cricket.response.TeamResponse;
import com.example.cricket.service.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@PostMapping("/addTeam")
	public TeamResponse AddTeam(@RequestParam int tournamentId,@RequestBody Team team)
	{
		return teamService.AddTeam(tournamentId, team);
	}
	
	@GetMapping("/getAlTeams")
	public List<Team> GetAllTeam(@RequestParam int tournamentId)
	{
		return teamService.GetAllTeam(tournamentId);
	}

}
