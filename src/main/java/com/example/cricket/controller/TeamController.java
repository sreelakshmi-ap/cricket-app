package com.example.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.Team;
import com.example.cricket.request.PlayersAchievementsRequest;
import com.example.cricket.response.MessageResponse;

import com.example.cricket.response.StandingResponse;
import com.example.cricket.response.TeamInfoResponse;

import com.example.cricket.response.TeamResponse;
import com.example.cricket.service.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addTeam")
	public TeamResponse AddTeam(@RequestParam int tournamentId,@RequestBody Team team)
	{
		return teamService.AddTeam(tournamentId, team);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAlTeams")
	public List<Team> GetAllTeam(@RequestParam int tournamentId)
	{
		return teamService.GetAllTeam(tournamentId);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/endOfMatch/setTeamInfo")
	public MessageResponse setTeamInfo(@RequestParam int tournament_id,int team_1_id,int team_2_id,int match_id,String end_time,
			@RequestBody PlayersAchievementsRequest request) {
	  return teamService.setTeamInfo(tournament_id,team_1_id, team_2_id, match_id, end_time,request);
		
		
    }
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/getTeamStandings")
	public List<StandingResponse> getTeamStandings(@RequestParam int tournament_id) {
		return teamService.getTeamStandings(tournament_id);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/getTeamInfo")
		public List<TeamInfoResponse> getTeamInfo(@RequestParam int team_id) {
	
			return teamService.getTeamInfo(team_id);
			
		}
}
