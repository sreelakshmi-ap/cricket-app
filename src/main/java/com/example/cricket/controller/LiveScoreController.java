package com.example.cricket.controller;

import com.example.cricket.service.LiveScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiveScoreController {

    @Autowired
    private LiveScoreService liveScoreService;

    @GetMapping("/getLiveScore/{matchId}")
    public ResponseEntity getLiveScore(@PathVariable int matchId){
        return liveScoreService.getLiveScore(matchId);
    }


    @GetMapping("/getScoreBoard/{matchId}")
    public ResponseEntity getScoreBoard(@PathVariable int matchId){
        return liveScoreService.getScoreBoard(matchId);
    }
    
    @GetMapping("/getRecent")
    public ResponseEntity getRecent(@RequestParam int matchId,@RequestParam  int teamId) {
    	return liveScoreService.getRecent(matchId, teamId);
    }
}
