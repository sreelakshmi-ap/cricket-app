package com.example.cricket.service;

import com.example.cricket.model.*;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamPlayerRepository;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.request.Playing;
import com.example.cricket.request.Toss;
import com.example.cricket.response.MainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UpdateScoreServiceImpl implements UpdateScoreService {

    @Autowired
    private TeamScoreRepository teamScoreRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    @Autowired
    private PlayerScoreRepository playerScoreRepository;


    @Override
    public ResponseEntity toss(Toss toss) {
        Optional<TeamScore> tossWinner = Optional.ofNullable(teamScoreRepository.findByMatchIdAndTeamId(toss.getMatchId(), toss.getTeamId()));
        if (tossWinner.isPresent()) {
            tossWinner.get().setBattingOrder(toss.isTossWinner());
           teamScoreRepository.save(tossWinner.get());
            return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", ""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID or Team ID not found", ""));

    }

    @Override
    public ResponseEntity startMatch(int matchId) {
        Optional<Matchs> currentMatch = matchRepository.findByMatchId(matchId);
        if (currentMatch.isPresent()) {
            Matchs match = currentMatch.get();
            if(match.getStatus().equals("Live")){
                return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Match has already started",""));
            }
            match.setStatus("Live");
            match.setStart_time(LocalTime.now());
            matchRepository.save(match);
            TeamScore teamOneScore = new TeamScore(matchId, currentMatch.get().getTeam_1_id(), false, 0, 0, 0, 0, 0, 0, 0);
            TeamScore teamTwoScore = new TeamScore(matchId, currentMatch.get().getTeam_2_id(), false, 0, 0, 0, 0, 0, 0, 0);
            teamScoreRepository.save(teamOneScore);
            teamScoreRepository.save(teamTwoScore);
            List<TeamPlayerEntity> teamOnePlayers = teamPlayerRepository.findByTeamId(currentMatch.get().getTeam_1_id());
            List<TeamPlayerEntity> teamTwoPlayers = teamPlayerRepository.findByTeamId(currentMatch.get().getTeam_2_id());
            List<TeamPlayerEntity> players = new ArrayList<>();
            players.addAll(teamOnePlayers);
            players.addAll(teamTwoPlayers);
            for (TeamPlayerEntity player : players) {
                PlayerScore score = new PlayerScore(player.getTeamId(), player.getPlayerId(),matchId,false,false,false,0,0,0,0,0,0,0,0,0,false);
                playerScoreRepository.save(score);
            }
            return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success",""));

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID not found", ""));
    }

    @Override
    public ResponseEntity batsmenList(int matchId) {
        Optional<Matchs> currentMatch = matchRepository.findByMatchId(matchId);
        if(currentMatch.isPresent()){
            if(currentMatch.get().getStatus().equals("Live")){
                List<?> batsmen = new ArrayList<>();
                if(currentMatch.get().getInnings() == 1){
                    batsmen = playerScoreRepository.findAllBatsmen(matchId,true);
                }else if(currentMatch.get().getInnings() == 2){
                     batsmen = playerScoreRepository.findAllBatsmen(matchId,false);
                }
                return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success",batsmen));

            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID not found", ""));
    }

    @Override
    public ResponseEntity bowlerList(int matchId) {
        Optional<Matchs> currentMatch = matchRepository.findByMatchId(matchId);
        if(currentMatch.isPresent()){
            if(currentMatch.get().getStatus().equals("Live")){
                List<?> bowlers = new ArrayList<>();
                if(currentMatch.get().getInnings() == 1){
                    bowlers = playerScoreRepository.findAllPlayer(matchId,false);
                }else if(currentMatch.get().getInnings() == 2){
                    bowlers = playerScoreRepository.findAllPlayer(matchId,true);
                }
                return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success",bowlers));

            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID not found", ""));
    }

    @Override
    public ResponseEntity currentPlaying(List<Playing> playingList, int matchId) {
        Optional<Matchs> currentMatch = matchRepository.findByMatchId(matchId);
        if(currentMatch.isPresent()){
            if(currentMatch.get().getStatus().equals("Live")){
             for(Playing player : playingList){
                 PlayerScore score = playerScoreRepository.findByPlayerIdAndMatchId(player.getPlayerId(),matchId);
                 score.setBatting(player.isBatting());
                 score.setBowling(player.isBowling());
                 score.setOnCrease(player.isOnCrease());
                 playerScoreRepository.save(score);
             }
                return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success",""));

            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID not found", ""));
    }
}
