package com.example.cricket.controller;

import com.example.cricket.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
