package com.example.cricket.service;

import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.request.Toss;
import com.example.cricket.response.MainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateScoreServiceImpl implements UpdateScoreService {

    @Autowired
    private TeamScoreRepository teamScoreRepository;

    @Override
    public ResponseEntity toss(Toss toss) {
        Optional<TeamScore> tossWinner = Optional.ofNullable(teamScoreRepository.findByMatchIdAndTeamId(toss.getMatchId(), toss.getTeamId()));
        if(tossWinner.isPresent()){
            tossWinner.get().setBattingOrder(toss.isTossWinner());
            teamScoreRepository.save(tossWinner.get());
            return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200,"Success",""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409,"Match ID or Team ID not found",""));

    }
}
