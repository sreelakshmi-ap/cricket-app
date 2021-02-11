package com.example.cricket.service;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.LiveUpdateRepository;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.response.LiveScore;
import com.example.cricket.response.MainResponse;
import com.example.cricket.response.MatchLiveScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LiveScoreServiceImpl implements LiveScoreService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamScoreRepository teamScoreRepository;

    @Autowired
    private PlayerScoreRepository playerScoreRepository;

    @Autowired
    private LiveUpdateRepository liveUpdateRepository;

    @Override
    public ResponseEntity getLiveScore(int matchId) {
        Optional<Matchs> currentMatch = matchRepository.findByMatchId(matchId);
        if (currentMatch.isPresent()) {
            if (currentMatch.get().getStatus().equals("Live")) {
                TeamScore teamOne = teamScoreRepository.findByMatchIdAndTeamId(matchId, currentMatch.get().getTeam_1_id());
                TeamScore teamTwo = teamScoreRepository.findByMatchIdAndTeamId(matchId, currentMatch.get().getTeam_2_id());
                LiveScore teamOneScore = new LiveScore();
                LiveScore teamTwoScore = new LiveScore();
                teamOneScore.setTeam(teamOne);
                teamTwoScore.setTeam(teamTwo);
                if (currentMatch.get().getInnings() == 1) {
                    MatchLiveScore liveScore = new MatchLiveScore();
                    liveScore.setInnings(1);

                    if (teamOne.isBattingOrder() == true) {
                        teamOneScore.setBatsmen(playerScoreRepository.findPlayingBatsmen(matchId, teamOne.getTeamId()));
                        teamOneScore.setCommentary(liveUpdateRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
                    } else if (teamOne.isBattingOrder() == false) {
                        teamTwoScore.setBowlers(playerScoreRepository.findPlayingBowler(matchId, teamOne.getTeamId()));
                    }
                    if (teamTwo.isBattingOrder() == true) {
                        teamTwoScore.setBatsmen(playerScoreRepository.findPlayingBatsmen(matchId, teamTwo.getTeamId()));
                        teamTwoScore.setCommentary(liveUpdateRepository.findAllByMatchIdAndTeamId(matchId,teamTwo.getTeamId()));


                    } else if (teamTwo.isBattingOrder() == false) {
                        teamOneScore.setBowlers(playerScoreRepository.findPlayingBowler(matchId, teamTwo.getTeamId()));

                    }
                    liveScore.setTeamOne(teamOneScore);
                    liveScore.setTeamTwo(teamTwoScore);

                    return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", liveScore));


                } else if (currentMatch.get().getInnings() == 2) {
                    MatchLiveScore liveScore = new MatchLiveScore();
                    liveScore.setInnings(2);

                    if (teamOne.isBattingOrder() == false) {
                        teamOneScore.setBatsmen(playerScoreRepository.findPlayingBatsmen(matchId, teamOne.getTeamId()));
                        teamOneScore.setCommentary(liveUpdateRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
                    } else if (teamOne.isBattingOrder() == true) {
                        teamTwoScore.setBowlers(playerScoreRepository.findPlayingBowler(matchId, teamOne.getTeamId()));
                    }
                    if (teamTwo.isBattingOrder() == false) {
                        teamTwoScore.setBatsmen(playerScoreRepository.findPlayingBatsmen(matchId, teamTwo.getTeamId()));
                        teamTwoScore.setCommentary(liveUpdateRepository.findAllByMatchIdAndTeamId(matchId,teamTwo.getTeamId()));


                    } else if (teamTwo.isBattingOrder() == true) {
                        teamOneScore.setBowlers(playerScoreRepository.findPlayingBowler(matchId, teamTwo.getTeamId()));

                    }
                    liveScore.setTeamOne(teamOneScore);
                    liveScore.setTeamTwo(teamTwoScore);

                    return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", liveScore));



                }

            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID not found", ""));
    }
}
