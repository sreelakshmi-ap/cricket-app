package com.example.cricket.controller;

import com.example.cricket.request.Toss;
import com.example.cricket.service.UpdateScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
