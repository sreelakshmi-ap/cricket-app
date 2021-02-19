package com.example.cricket.service;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.*;
import com.example.cricket.response.*;
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

    @Autowired
    private FallOfWicketRepository fallOfWicketRepository;

    @Autowired
    private BattingPartnershipRepository battingPartnershipRepository;

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
                        teamOneScore.setPartnership(battingPartnershipRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
                        teamOneScore.setFallOfWicket(fallOfWicketRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
                        teamOneScore.setCommentary(liveUpdateRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
                    } else if (teamOne.isBattingOrder() == false) {
                        teamTwoScore.setBowlers(playerScoreRepository.findPlayingBowler(matchId, teamOne.getTeamId()));
                    }
                    if (teamTwo.isBattingOrder() == true) {
                        teamTwoScore.setBatsmen(playerScoreRepository.findPlayingBatsmen(matchId, teamTwo.getTeamId()));
                        teamTwoScore.setPartnership(battingPartnershipRepository.findAllByMatchIdAndTeamId(matchId,teamTwo.getTeamId()));
                        teamTwoScore.setFallOfWicket(fallOfWicketRepository.findAllByMatchIdAndTeamId(matchId,teamTwo.getTeamId()));
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
                        teamOneScore.setPartnership(battingPartnershipRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
                        teamOneScore.setFallOfWicket(fallOfWicketRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
                        teamOneScore.setCommentary(liveUpdateRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
                    } else if (teamOne.isBattingOrder() == true) {
                        teamTwoScore.setBowlers(playerScoreRepository.findPlayingBowler(matchId, teamOne.getTeamId()));
                    }
                    if (teamTwo.isBattingOrder() == false) {
                        teamTwoScore.setBatsmen(playerScoreRepository.findPlayingBatsmen(matchId, teamTwo.getTeamId()));
                        teamTwoScore.setPartnership(battingPartnershipRepository.findAllByMatchIdAndTeamId(matchId,teamTwo.getTeamId()));
                        teamTwoScore.setFallOfWicket(fallOfWicketRepository.findAllByMatchIdAndTeamId(matchId,teamTwo.getTeamId()));
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

    @Override
    public ResponseEntity getScoreBoard(int matchId) {
        Optional<Matchs> currentMatch = matchRepository.findByMatchId(matchId);
        if (currentMatch.isPresent()) {
            TeamScore teamOne = teamScoreRepository.findByMatchIdAndTeamId(matchId, currentMatch.get().getTeam_1_id());
            TeamScore teamTwo = teamScoreRepository.findByMatchIdAndTeamId(matchId, currentMatch.get().getTeam_2_id());
            ScoreBoard teamOneScore = new ScoreBoard();
            ScoreBoard teamTwoScore = new ScoreBoard();
            teamOneScore.setTeam(teamOne);
            teamTwoScore.setTeam(teamTwo);
            List<Batsman> teamOneBatsman = playerScoreRepository.findAllBatsmen(matchId, teamOne.getTeamId());
            List<BatsmanDetails> teamOneBatsmanDetails = new ArrayList<>();
            for(Batsman batsman1 :teamOneBatsman){
                if(batsman1.getBatsmanOut() == true){
                   OutReason reason = liveUpdateRepository.findOutReason(matchId,teamOne.getTeamId(),batsman1.getId());
                    teamOneBatsmanDetails.add(new BatsmanDetails(batsman1.getId(),batsman1.getPlayerName(),batsman1.getRunScored(),batsman1.getBallFaced(),batsman1.getBatsmenSr(),batsman1.getNoOfFours(),batsman1.getNoOfSixes(),batsman1.getOnCrease(),batsman1.getBatsmanOut(),reason.getFielderName(),reason.getWicketReason()));
                }else {
                    teamOneBatsmanDetails.add(new BatsmanDetails(batsman1.getId(),batsman1.getPlayerName(),batsman1.getRunScored(),batsman1.getBallFaced(),batsman1.getBatsmenSr(),batsman1.getNoOfFours(),batsman1.getNoOfSixes(),batsman1.getOnCrease(),batsman1.getBatsmanOut(),null,null));
                }
            }
            teamOneScore.setBatsmen(teamOneBatsmanDetails);
            teamOneScore.setBowlers(playerScoreRepository.findALLBowler(matchId, teamTwo.getTeamId()));
            teamOneScore.setFallOfWicket(fallOfWicketRepository.findAllByMatchIdAndTeamId(matchId,teamOne.getTeamId()));
            List<Batsman> teamTwoBatsman = playerScoreRepository.findAllBatsmen(matchId, teamTwo.getTeamId());
            List<BatsmanDetails> teamTwoBatsmanDetails = new ArrayList<>();
            for(Batsman batsman1 :teamTwoBatsman){
                if(batsman1.getBatsmanOut() == true){
                    OutReason reason = liveUpdateRepository.findOutReason(matchId,teamTwo.getTeamId(),batsman1.getId());
                    teamTwoBatsmanDetails.add(new BatsmanDetails(batsman1.getId(),batsman1.getPlayerName(),batsman1.getRunScored(),batsman1.getBallFaced(),batsman1.getBatsmenSr(),batsman1.getNoOfFours(),batsman1.getNoOfSixes(),batsman1.getOnCrease(),batsman1.getBatsmanOut(),reason.getFielderName(),reason.getWicketReason()));
                }else {
                    teamTwoBatsmanDetails.add(new BatsmanDetails(batsman1.getId(),batsman1.getPlayerName(),batsman1.getRunScored(),batsman1.getBallFaced(),batsman1.getBatsmenSr(),batsman1.getNoOfFours(),batsman1.getNoOfSixes(),batsman1.getOnCrease(),batsman1.getBatsmanOut(),null,null));
                }
            }
            teamTwoScore.setBatsmen(teamTwoBatsmanDetails);
            teamTwoScore.setBowlers(playerScoreRepository.findALLBowler(matchId, teamOne.getTeamId()));
            teamTwoScore.setFallOfWicket(fallOfWicketRepository.findAllByMatchIdAndTeamId(matchId,teamTwo.getTeamId()));
            MatchScoreBoard scoreBoard = new MatchScoreBoard();
            scoreBoard.setTeamOne(teamOneScore);
            scoreBoard.setTeamTwo(teamTwoScore);

            return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", scoreBoard));



        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID not found", ""));

    }
}
