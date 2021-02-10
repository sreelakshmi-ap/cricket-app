package com.example.cricket.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.Team;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.PlayerRepository;
import com.example.cricket.repository.TeamRepo;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.response.MessageResponse;
import com.example.cricket.response.TeamInfoResponse;
import com.example.cricket.response.TeamResponse;

@Service
public class TeamService {
	
	@Autowired
	TeamRepo teamRepo;
	
	@Autowired
	TeamScoreRepository teamScoreRepository;
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	PlayerRepository playerRepo;
	
	
	
	public TeamResponse AddTeam(int tournamentId,Team team)
	{
		team.setTournamentId(tournamentId);
		teamRepo.save(team);
		return new TeamResponse(team,"Team Added",HttpStatus.OK);
	}
	

     public MessageResponse setTeamInfo(int team_1_id,int team_2_id,int match_id,String end_time) {
		
	TeamScore team1Score=teamScoreRepository.findByMatchIdAndTeamId(match_id, team_1_id);
	int team1Run=team1Score.getRuns();
	
	
	TeamScore team2Score=teamScoreRepository.findByMatchIdAndTeamId(match_id, team_2_id);
	int team2Run=team2Score.getRuns();
	
	
	if(team1Run>team2Run) {
		Team team1= teamRepo.findById(team_1_id).get();
		
		
		if(team1.getWins()==null) { 
		team1.setTeamId(team_1_id);
		team1.setWins(1);
		}
		else {
			team1.setTeamId(team_1_id);
			team1.setWins(team1.getWins()+1);
			
		}
		if( team1.getPoints()==null) {
		team1.setPoints(2);
		teamRepo.save(team1);
		}
		
		else {
			team1.setPoints(team1.getPoints()+2);
			teamRepo.save(team1);
			
		}
		
		
		Team team2= teamRepo.findById(team_2_id).get();
		if(team2.getLosses()==null) {
		team2.setTeamId(team_2_id);
		team2.setLosses(1);
		teamRepo.save(team2);
		}
		
		else {
			team2.setTeamId(team_2_id);
			team2.setLosses(team2.getLosses()+1);
			teamRepo.save(team2);
			
		}
		
		Matchs match=matchRepository.findById(match_id).get();
		match.setMatch_id(match_id);
		LocalTime endTime=LocalTime.parse(end_time);
		match.setEnd_time(endTime);
		match.setStatus("Past");
		
		String team1Name=team1.getTeamName();
		int runs=team1Run-team2Run;
		match.setStopped_reason(team1Name+" "+"won by"+" "+runs+" "+"runs");
		matchRepository.save(match);
	
 
	}
	
	if(team1Run<team2Run) {
		
		Team team2= teamRepo.findById(team_2_id).get();
		
		if(team2.getWins()!=null){
		team2.setTeamId(team_2_id);
		team2.setWins(team2.getWins()+1);
		}
		else {
			team2.setTeamId(team_2_id);
			team2.setWins(1);
		}
		
		if(team2.getPoints()!=null) {
		team2.setPoints(team2.getPoints()+2);
		
		teamRepo.save(team2);
		}
		else {
			team2.setPoints(2);
			teamRepo.save(team2);
			
		}
		
		Team team1= teamRepo.findById(team_1_id).get();
		if(team1.getLosses()!=null) {
		team1.setTeamId(team_1_id);
		team1.setLosses(team1.getLosses()+1);
		
		teamRepo.save(team1);
		}
		else {
			team1.setTeamId(team_1_id);
			team1.setLosses(1);
			
			teamRepo.save(team1);
			
		}
		
		Matchs match=matchRepository.findById(match_id).get();
		match.setMatch_id(match_id);
		LocalTime endTime=LocalTime.parse(end_time);
		match.setEnd_time(endTime);
		match.setStatus("Past");
				
		
		String team2Name=team2.getTeamName();
		int runs=team2Run-team1Run;
		match.setStopped_reason(team2Name+" "+"won by"+" "+runs+" "+"runs");
		matchRepository.save(match);
		
		
	}
	
	if(team1Run==team2Run) {
		
		Team team2= teamRepo.findById(team_2_id).get();
		Team team1= teamRepo.findById(team_1_id).get();
		if(team2.getDraw_or_cancelled()!=null) {
		team2.setTeamId(team_2_id);
		team2.setDraw_or_cancelled(team2.getDraw_or_cancelled()+1);
		if(team2.getPoints()!=null) {
		team2.setPoints(team2.getPoints()+1);
		}else {
			team2.setPoints(1);
		}
		teamRepo.save(team2);
		}
		else {
			team2.setTeamId(team_2_id);
			team2.setDraw_or_cancelled(1);
			if(team2.getPoints()==null) {
			team2.setPoints(1);
			}
			else {
				team2.setPoints(team2.getPoints()+1);
			}
			teamRepo.save(team2);
			
			
		}
		
		if(team1.getDraw_or_cancelled()!=null) {
		team1.setTeamId(team_1_id);
		team1.setDraw_or_cancelled(team1.getDraw_or_cancelled()+1);
		if(team1.getPoints()!=null) {
		team1.setPoints(team1.getPoints()+1);
		}
		else {
			team1.setPoints(1);
			
		}
		teamRepo.save(team1);
		}
		
		else {
			
			team1.setTeamId(team_1_id);
			team1.setDraw_or_cancelled(1);
			if(team1.getPoints()==null) {
			team1.setPoints(1);
			}
			else {
				team1.setPoints(team1.getPoints()+1);
			}
			teamRepo.save(team1);
			
		}
		
		
		Matchs match=matchRepository.findById(match_id).get();
		match.setMatch_id(match_id);
		LocalTime endTime=LocalTime.parse(end_time);
		match.setEnd_time(endTime);
	
		match.setStopped_reason("Draw match");
		match.setStatus("Past");
		matchRepository.save(match);
		
	}
	
	
	
	return new MessageResponse("team information updated successfully",HttpStatus.OK);

    }
	
	public List<Team> GetAllTeam(int tournamentId)
	{
		return teamRepo.findAllByTournamentId(tournamentId);
	}
	
	public List<TeamInfoResponse> getTeamInfo(int teamId) {
        List<String> teamInfo= teamRepo.getTeamInfo(teamId);
        List<TeamInfoResponse> teamInfos=new ArrayList<>();
        TeamInfoResponse response;
        String city;
    	Integer wins;
    	Integer losses;
    	Integer draw_or_cancelled;
    	Integer points;
        for(String teamInformation:teamInfo) {
    		String[] orderValues = teamInformation.split(",");
    		city=orderValues[0];
    		draw_or_cancelled=Integer.parseInt(orderValues[1]);
    		losses= Integer.parseInt(orderValues[2]);
    		wins=Integer.parseInt(orderValues[3]);
    		
    		points=Integer.parseInt(orderValues[4]);
	        int captainId=teamRepo.getTeamCaptain(teamId);
	        String captain=playerRepo.getPlayerName(captainId);
	        int count=teamRepo.getMatchCount1(teamId);
	        int count1=teamRepo.getMatchCount2(teamId);
	        int counts=count+count1;
	        response= new TeamInfoResponse(city,counts,wins,losses,draw_or_cancelled,points,captain);
		    teamInfos.add(response);
	}
        return teamInfos;
	
	}
}
