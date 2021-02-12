package com.example.cricket.service;

import java.time.LocalDate;
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
import com.example.cricket.repository.TeamRepo;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.response.InningsResponse;
import com.example.cricket.response.MatchResponse;
import com.example.cricket.response.MessageResponse;


@Service
public class MatchService {
	
	@Autowired
	MatchRepository matchRepository;
	

	@Autowired
	TournamentRepo tournamentRepo; 
	
	@Autowired
	TeamRepo teamRepo;   
	
	@Autowired
	TeamScoreRepository teamScoreRepository;
	                      
                                

	public InningsResponse setInnings(int match_id,int innings)

	{
		Matchs matchs=matchRepository.findById(match_id).get();
		matchs.setInnings(innings);
		matchRepository.save(matchs);
		return new InningsResponse(match_id,innings,"Innings Added",HttpStatus.OK);
		
	}


	public List<MatchResponse> getAllMatchsForTournament(String tournament_code) {
		List<MatchResponse> matchResponse=new ArrayList<>();
			
		int tournamentId=tournamentRepo.findByTournamentCode(tournament_code);
		List<String> matchs=matchRepository.getAllMatchs(tournamentId);
		String match_name,status,stopped_reason,team1Name,team2Name;
		LocalDate match_date;
		int ground_id,team_1_id,team_2_id,match_id,team_1_score,team_1_wicket,team_2_score,
		team_2_wicket;
		float team_1_overs,team_2_overs;
		MatchResponse response;
		for(String match:matchs) {
		String[] orderValues = match.split(",");
		match_id=Integer.parseInt(orderValues[0]);;
		match_name = orderValues[1];
		status = orderValues[2];
		match_date=LocalDate.parse(orderValues[3]);
		stopped_reason=orderValues[4];
		ground_id = Integer.parseInt(orderValues[5]);
        team_1_id = Integer.parseInt(orderValues[6]);
		team_2_id = Integer.parseInt(orderValues[7]);
		Team teams=teamRepo.findById(team_1_id).get();
		team1Name=teams.getTeamName();
		Team teams2=teamRepo.findById(team_2_id).get();
		team2Name=teams2.getTeamName();
		
		response= new MatchResponse(match_name,ground_id,status,match_date,team1Name,team2Name,stopped_reason);
		TeamScore team1Score=teamScoreRepository.findByMatchIdAndTeamId(match_id,team_1_id);
		if(team1Score!=null) {
		System.out.println(team1Score);
		team_1_score=team1Score.getRuns();
		team_1_wicket=team1Score.getWickets();
		team_1_overs=team1Score.getOvers();
		response.setTeam_1_score(team_1_score);
		response.setTeam_1_overs(team_1_overs);
		response.setTeam_1_wicket(team_1_wicket);
		}

		TeamScore team2Score=teamScoreRepository.findByMatchIdAndTeamId(match_id,team_2_id);
		if(team2Score!=null) {
		System.out.println(team2Score);
		team_2_score=team2Score.getRuns();
		team_2_wicket=team2Score.getWickets();
		team_2_overs=team2Score.getOvers();
		
		response.setTeam_2_overs(team_2_overs);
		response.setTeam_2_score(team_2_score);
		response.setTeam_2_wicket(team_2_wicket);
		}
		matchResponse.add(response);
		
	}
		return matchResponse;
 }
	
	
	public List<MatchResponse> getAllMatchs(int tournament_id){
		List<MatchResponse> matchResponse=new ArrayList<>();
		List<String> matchs=matchRepository.getAllMatchs(tournament_id);
		String match_name,status,stopped_reason,team1Name,team2Name;
		LocalDate match_date;
		int ground_id,team_1_id,team_2_id,match_id,team_1_score,team_1_wicket,team_2_score,
		team_2_wicket;
		float team_1_overs,team_2_overs;
		MatchResponse response;
		for(String match:matchs) {
		String[] orderValues = match.split(",");
		match_id=Integer.parseInt(orderValues[0]);;
		match_name = orderValues[1];
		status = orderValues[2];
		match_date=LocalDate.parse(orderValues[3]);
		stopped_reason=orderValues[4];
		ground_id = Integer.parseInt(orderValues[5]);
        team_1_id = Integer.parseInt(orderValues[6]);
		team_2_id = Integer.parseInt(orderValues[7]);
		Team teams=teamRepo.findById(team_1_id).get();
		team1Name=teams.getTeamName();
		Team teams2=teamRepo.findById(team_2_id).get();
		team2Name=teams2.getTeamName();
		
		response= new MatchResponse(match_name,ground_id,status,match_date,team1Name,team2Name,stopped_reason);
		TeamScore team1Score=teamScoreRepository.findByMatchIdAndTeamId(match_id,team_1_id);
		if(team1Score!=null) {
		System.out.println(team1Score);
		team_1_score=team1Score.getRuns();
		team_1_wicket=team1Score.getWickets();
		team_1_overs=team1Score.getOvers();
		response.setTeam_1_score(team_1_score);
		response.setTeam_1_overs(team_1_overs);
		response.setTeam_1_wicket(team_1_wicket);
		}

		TeamScore team2Score=teamScoreRepository.findByMatchIdAndTeamId(match_id,team_2_id);
		if(team2Score!=null) {
		System.out.println(team2Score);
		team_2_score=team2Score.getRuns();
		team_2_wicket=team2Score.getWickets();
		team_2_overs=team2Score.getOvers();
		
		response.setTeam_2_overs(team_2_overs);
		response.setTeam_2_score(team_2_score);
		response.setTeam_2_wicket(team_2_wicket);
		}
		matchResponse.add(response);
		
	}
		return matchResponse;
 }
		
//	public MessageResponse stopMatch(int match_id,String reason,String end_time) {
//		Matchs match=matchRepository.findByMatchId(match_id).get();
//		match.setMatch_id(match_id);
//		match.setStopped_reason(reason);
//		LocalTime endTime=LocalTime.parse(end_time);
//		match.setEnd_time(endTime);
//		match.setStatus("Abondoned");
//		
//		matchRepository.save(match);
//		return new MessageResponse("match information saved successfully",HttpStatus.OK);
//		
//	}
	
	public MessageResponse stopMatch(int match_id,String reason,String end_time) {
		Matchs match=matchRepository.findByMatchId(match_id).get();
		match.setMatch_id(match_id);
		match.setStopped_reason(reason);
		LocalTime endTime=LocalTime.parse(end_time);
		match.setEnd_time(endTime);
		match.setStatus("Abondoned");
		
		matchRepository.save(match);
		return new MessageResponse("match information saved successfully",HttpStatus.OK);
		
	}
		
		
	
}

