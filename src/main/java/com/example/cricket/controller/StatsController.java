package com.example.cricket.controller;


import com.example.cricket.service.StatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.cricket.response.ListAndMessageResponse;



@RestController
public class StatsController {

    @Autowired
    private StatsService statsService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getHighestScore/{tournamentId}")
    public ResponseEntity getHighestScore(@PathVariable int tournamentId){
        return statsService.getHighestScore(tournamentId);

    }
    

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getBestBattingStrikeRate/{tournamentId}")
    public ResponseEntity getBestBattingStrikeRate(@PathVariable int tournamentId){
        return statsService.getBestBattingStrikeRate(tournamentId);
    }
    

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getBestEconomy/{tournamentId}")
    public ResponseEntity getBestEconomy(@PathVariable int tournamentId){
        return statsService.getBestEconomy(tournamentId);
    }

    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getBestBowlingStrikeRate/{tournamentId}")
    public ResponseEntity getBestBowlingStrikeRate(@PathVariable int tournamentId){
        return statsService.getBestBowlingStrikeRate(tournamentId);
    }
    
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getHighestFifer")
    public ResponseEntity<?> getHighestFifer(@RequestParam int tournamentId)
    {
    	return statsService.getHighestFifer(tournamentId);
    }
    
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getMostWicketTaker")
    public ResponseEntity<?> getMostWickets(@RequestParam int tournamentId)
    {
    	return statsService.getMostWickets(tournamentId);
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getTopTenFifers")
    public ResponseEntity<?> getTopTenFifers(@RequestParam int tournamentId)
    {
    	return statsService.getTopTenFifers(tournamentId);
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getTopTenWicketTakers")
    public ResponseEntity<?> getTopTenWicketTakers(@RequestParam int tournamentId)
    {
    	return statsService.getTopTenWicketTakers(tournamentId);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getBestBowling")
    public ResponseEntity<?> getBesBowling(@RequestParam int tournamentId)
    {
    	return statsService.getBesBowling(tournamentId);
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getBestBttingAverage")
    public ListAndMessageResponse getBestBattingAverage(@RequestParam int tournament_id){
    	return statsService.getBestBattingAverage(tournament_id);
    }
    
    //best bowling average= runs/wickets
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getBestBowlingAverage")
    public ResponseEntity<?> getBestBowlingAverage(@RequestParam int tournament_id){
    	return statsService.getBestBowlingAverage(tournament_id);
    }


}
