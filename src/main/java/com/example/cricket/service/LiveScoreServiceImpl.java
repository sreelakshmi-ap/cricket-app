package com.example.cricket.service;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.response.MainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiveScoreServiceImpl implements LiveScoreService{

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public ResponseEntity getLiveScore(int matchId) {
        Optional<Matchs> currentMatch = matchRepository.findByMatchId(matchId);
        if(currentMatch.isPresent()){
            if (currentMatch.get().getStatus().equals("Live")) {
                if (currentMatch.get().getInnings() == 1) {



                } else if (currentMatch.get().getInnings() == 2) {


                }

            }
            }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID not found", ""));
    }
}
