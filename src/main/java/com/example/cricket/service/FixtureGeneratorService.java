package com.example.cricket.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Fixture;
import com.example.cricket.model.Matchs;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.TeamRepo;
import com.example.cricket.repository.TournamentGroundRepository;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.repository.Tournament_umpire_mapping_Repository;

@Service
public class FixtureGeneratorService<T extends Object> {
	
	@Autowired
	TeamRepo teamRepo;
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	TournamentGroundRepository tournamentGroundRepository;
	
	@Autowired
	TournamentRepo tournamentRepo;
	
	@Autowired
	Tournament_umpire_mapping_Repository repo;
	

	
	public void generateFixture(int tournament_id) {
		FixtureGeneratorService<Integer> fixtureGenerator=new FixtureGeneratorService();
		List<Integer> teams = teamRepo.getTeams(tournament_id);
		List<Integer> grounds=tournamentGroundRepository.getGroundsForMatchs(tournament_id);
		Integer[] arr = new Integer[grounds.size()]; 
		  
        for (int i =0; i < grounds.size(); i++) {
            arr[i] = grounds.get(i);
        }
		
        LocalDate start_date=tournamentRepo.getStartDate(tournament_id);
        LocalDate end_date=tournamentRepo.getEndDate(tournament_id);
        
        List<Integer> umpires=repo.getAllUmpiresforMatch(tournament_id);
        Integer[] array = new Integer[umpires.size()]; 
		  
        for (int i =0; i < umpires.size(); i++) {
            array[i] = umpires.get(i);
        }
		
		int r=0;
		int index=0;
		int in=0;
		List<List<Fixture<Integer>>> rounds = fixtureGenerator.getFixtures(teams, true);
		for(int i=0; i<rounds.size(); i++) {
		    List<Fixture<Integer>> round = rounds.get(i);
		    
		    for(Fixture<Integer> fixture: round){
		        Matchs match=new Matchs();
		        match.setGround_id(arr[index]);
		        match.setMatch_name("match"+(r+1));                          
		        match.setTeam_1_id(fixture.getHomeTeam());
		        match.setTeam_2_id(fixture.getAwayTeam());
		        match.setTournamentId(tournament_id);
		        match.setMatch_date(start_date);
		        match.setUmpire_1_id(array[in]);
		        match.setUmpire_2_id(array[in+1]);
		        matchRepository.save(match);
		        r=r+1;
		        if(index==grounds.size()-1) {
		        	index=0;
		        }
		        else {
		        index=index+1;
		        }
		        if(in+1==umpires.size()-1) {
		        	in=0;
		        }
		        else {
		        	in=in+1;
		        }
		    }
		    start_date=start_date.plusDays(1);
		    if(start_date==end_date) {
		    	start_date=tournamentRepo.getStartDate(tournament_id);
		    }
		}
	}
	
	public List<List<Fixture<T>>> getFixtures(List<T> teams, boolean includeReverseFixtures) {

        int numberOfTeams = teams.size();
        
        // If odd number of teams add a "ghost".
        boolean ghost = false;
        if (numberOfTeams % 2 != 0) {
            numberOfTeams++;
            ghost = true;
        }

        // Generate the fixtures using the cyclic algorithm.
        int totalRounds = numberOfTeams - 1;
        int matchesPerRound = numberOfTeams / 2;
        List<List<Fixture<T>>> rounds = new LinkedList<List<Fixture<T>>>();

        for (int round = 0; round < totalRounds; round++) {
            List<Fixture<T>> fixtures = new LinkedList<Fixture<T>>();
            for (int match = 0; match < matchesPerRound; match++) {
                int home = (round + match) % (numberOfTeams - 1);
                int away = (numberOfTeams - 1 - match + round) % (numberOfTeams - 1);
                // Last team stays in the same place while the others
                // rotate around it.
                if (match == 0) {
                    away = numberOfTeams - 1;
                }
                fixtures.add(new Fixture<T>(teams.get(home), teams.get(away)));
            }
            rounds.add(fixtures);
        }

        // Interleave so that home and away games are fairly evenly dispersed.
        List<List<Fixture<T>>> interleaved = new LinkedList<List<Fixture<T>>>();

        int evn = 0;
        int odd = (numberOfTeams / 2);
        for (int i = 0; i < rounds.size(); i++) {
            if (i % 2 == 0) {
                interleaved.add(rounds.get(evn++));
            } else {
                interleaved.add(rounds.get(odd++));
            }
        }

        rounds = interleaved;

        // Last team can't be away for every game so flip them
        // to home on odd rounds.
        for (int roundNumber = 0; roundNumber < rounds.size(); roundNumber++) {
            if (roundNumber % 2 == 1) {
                Fixture fixture = rounds.get(roundNumber).get(0);
                rounds.get(roundNumber).set(0, new Fixture(fixture.getAwayTeam(), fixture.getHomeTeam()));
            }
        }
        
        if(includeReverseFixtures){
            List<List<Fixture<T>>> reverseFixtures = new LinkedList<List<Fixture<T>>>();
            for(List<Fixture<T>> round: rounds){
                List<Fixture<T>> reverseRound = new LinkedList<Fixture<T>>();
                for(Fixture<T> fixture: round){
                    reverseRound.add(new Fixture<T>(fixture.getAwayTeam(), fixture.getHomeTeam()));
                }
                reverseFixtures.add(reverseRound);
            }
            rounds.addAll(reverseFixtures);
        }

        return rounds;
    }

}
