package com.example.cricket.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.Team;
import com.example.cricket.model.TeamPlayerEntity;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.PlayerRepository;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.PlayersAchievementsRepository;
import com.example.cricket.repository.TeamPlayerRepository;
import com.example.cricket.repository.TeamRepo;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.response.InningsResponse;
import com.example.cricket.response.ListAndMessageResponse;
import com.example.cricket.response.MainResponse;
import com.example.cricket.response.MatchResponse;
import com.example.cricket.response.MessageResponse;
import com.example.cricket.response.ViewTournamentResponse;


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

	@Autowired
	PlayerRepository playerRepo;
	
	@Autowired
	PlayersAchievementsRepository repo;
	
	@Autowired
	TeamPlayerRepository teamPlayerRepository;
	
	@Autowired
	PlayerScoreRepository playerScoreRepository;
	                      
                                

	public InningsResponse setInnings(int match_id,int innings)

	{
		Matchs matchs=matchRepository.findById(match_id).get();
		matchs.setInnings(innings);
		matchRepository.save(matchs);
		return new InningsResponse(match_id,innings,"Innings Added",HttpStatus.OK);
		
	}


	public ResponseEntity<?> getAllMatchsForTournament(String tournament_code) {
		
		Integer tournamentId=tournamentRepo.findByTournamentCode(tournament_code);
		if(tournamentId!=null) {
		List<MatchResponse> matchResponse=new ArrayList<>();
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
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ListAndMessageResponse(matchResponse, HttpStatus.OK,matchResponse.size()));
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(404, "Tournament Not Found", ""));
		}
 }
	
	
	public ResponseEntity<?> getAllMatchs(int tournament_id){
		List<MatchResponse> matchResponse=new ArrayList<>();
		List<String> matchs=matchRepository.getAllMatchs(tournament_id);
		if(matchs!=null) {
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
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ListAndMessageResponse(matchResponse, HttpStatus.OK,matchResponse.size()));
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(404, "Tournament Not Found", ""));
		}
		
 }
		

	
	public MessageResponse stopMatch(int match_id,String reason,String end_time,int team_1_id,int team_2_id,
			int tournament_id) {
		
		
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
		
		int no_of_fours;
		int no_of_sixes;
		int run_scored;
		int wickets;
		
		List<Integer> players=playerScoreRepository.getMatchPlayers(match_id);
		System.out.println(players);
		for(Integer player:players) {
			System.out.println(player);
			String info=playerScoreRepository.getPlayerInfo(player,match_id);
			System.out.println(info);
	    		String[] arr =info.split(",");
	    		no_of_fours=Integer.parseInt(arr[0]);
	    		no_of_sixes=Integer.parseInt(arr[1]);
	    		run_scored=Integer.parseInt(arr[2]);
	    		wickets= Integer.parseInt(arr[3]);
	    		
	    	
			
			TeamPlayerEntity teamPlayer=teamPlayerRepository.getTeamPlayer(player,tournament_id);
			System.out.println(teamPlayer);
			
			if(teamPlayer.getFours()!=null) {
			teamPlayer.setFours(teamPlayer.getFours()+no_of_fours);
			}
			else {
				teamPlayer.setFours(no_of_fours);
			}
			
			if(teamPlayer.getSixes()!=null) {
			teamPlayer.setSixes(teamPlayer.getSixes()+no_of_sixes);
			}
			else {
				teamPlayer.setSixes(no_of_sixes);
			}
			
			if(teamPlayer.getWickets()!=null) {
			teamPlayer.setWickets(teamPlayer.getWickets()+wickets);
			}
			else {
				teamPlayer.setWickets(wickets);
			}
			
			if(teamPlayer.getRuns()!=null) {
			teamPlayer.setRuns(teamPlayer.getRuns()+run_scored);
			}
			
			else {
				teamPlayer.setRuns(run_scored);
			}
			
			if(run_scored>=50 && run_scored<100) {
				teamPlayer.setFifties(teamPlayer.getFifties()+1);
			}
			
			if(run_scored>=100) {
				teamPlayer.setHundreds(teamPlayer.getHundreds()+1);
			}
			
		    if(wickets>=5) {
		    	if(teamPlayer.getFive_wickets_hauls()!=null) {
		    	teamPlayer.setFive_wickets_hauls(teamPlayer.getFive_wickets_hauls()+1);
		    	}
		    	else {
		    		teamPlayer.setFive_wickets_hauls(0);
		    	}
		    }
			
		    teamPlayerRepository.save(teamPlayer);
			
		}
		
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

