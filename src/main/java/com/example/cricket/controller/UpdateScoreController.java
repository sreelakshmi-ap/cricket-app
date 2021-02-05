package com.example.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.request.Playing;
import com.example.cricket.request.Toss;
import com.example.cricket.service.UpdateScoreService;

@RestController
public class UpdateScoreController {

    @Autowired
    private UpdateScoreService updateScoreService;

    @PutMapping("/toss")
    public ResponseEntity toss(@RequestBody Toss toss){
        return updateScoreService.toss(toss);
    }

    @PutMapping("/startMatch/{matchId}")
    public ResponseEntity startMatch(@PathVariable int matchId){
        return updateScoreService.startMatch(matchId);
    }
    @GetMapping("/batsmenList/{matchId}")
    public ResponseEntity batsmenList(@PathVariable int matchId){
        return updateScoreService.batsmenList(matchId);
    }

    @GetMapping("/bowlerList/{matchId}")
    public ResponseEntity bowlerList(@PathVariable int matchId){
        return updateScoreService.bowlerList(matchId);
    }

    @PostMapping("/currentPlaying/{matchId}")
    public ResponseEntity currentPlaying(@RequestBody List<Playing> playingList,@PathVariable int matchId){
        return updateScoreService.currentPlaying(playingList,matchId);
    }
}
