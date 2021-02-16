package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.response.ListAndMessageResponse;
import com.example.cricket.service.StatsService;

@RestController
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/getHighestScore/{tournamentId}")
    public ResponseEntity getHighestScore(@PathVariable int tournamentId){
        return statsService.getHighestScore(tournamentId);

    }

    @GetMapping("/getBestBattingStrikeRate/{tournamentId}")
    public ResponseEntity getBestBattingStrikeRate(@PathVariable int tournamentId){
        return statsService.getBestBattingStrikeRate(tournamentId);
    }

    @GetMapping("/getBestEconomy/{tournamentId}")
    public ResponseEntity getBestEconomy(@PathVariable int tournamentId){
        return statsService.getBestEconomy(tournamentId);
    }
    
    @GetMapping("/getHighestFifer")
    public ResponseEntity<?> getHighestFifer(@RequestParam int tournamentId)
    {
    	return statsService.getHighestFifer(tournamentId);
    }
    
    @GetMapping("/getMostWicketTaker")
    public ResponseEntity<?> getMostWickets(@RequestParam int tournamentId)
    {
    	return statsService.getMostWickets(tournamentId);
    }
    
    @GetMapping("/getTopTenFifers")
    public ResponseEntity<?> getTopTenFifers(@RequestParam int tournamentId)
    {
    	return statsService.getTopTenFifers(tournamentId);
    }
    
    @GetMapping("/getTopTenWicketTakers")
    public ResponseEntity<?> getTopTenWicketTakers(@RequestParam int tournamentId)
    {
    	return statsService.getTopTenWicketTakers(tournamentId);
    }
    
    @GetMapping("/getBestBttingAverage")
    public ListAndMessageResponse getBestBattingAverage(@RequestParam int tournament_id){
    	return statsService.getBestBattingAverage(tournament_id);
    }
}
