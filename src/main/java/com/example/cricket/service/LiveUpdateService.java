package com.example.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket.model.LiveUpdate;
import com.example.cricket.model.PlayerScore;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.LiveUpdateRepository;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.request.LiveUpdateRequest;

@Service
public class LiveUpdateService {
	@Autowired
	LiveUpdateRepository liveUpdateRepository;

	@Autowired
	PlayerScoreRepository playerScoreRepository;

	@Autowired
	TeamScoreRepository teamScoreRepository;

	public LiveUpdate UpdateLiveScore(LiveUpdateRequest request) {

		LiveUpdate liveUpdate = request.getLiveUpdate();
		if (liveUpdate.getBall_type().isEmpty()) {
			liveUpdate.setBall_type("Good ball");
		}
//		liveUpdate.setBallno(nextBall(String balltype, int ballnumber));

		return liveUpdateRepository.save(liveUpdate);
	}

	public int nextBall(String balltype, int ballnumber) {
		if (!(balltype.equals("Wb") || (balltype.equals("Nb")))) {
			ballnumber += 1;
		}
		return ballnumber;
	}

	public void BowlerScoreUpdate(LiveUpdateRequest request) {
		LiveUpdate liveUpdate = request.getLiveUpdate();
		// Updating PlayerScore Table for Bowler
		PlayerScore playerScore = playerScoreRepository.findPlayer(liveUpdate.getBowler_id(), liveUpdate.getMatch_id());
		// no of maidens
		TeamScore teamScore = teamScoreRepository.findByMatchIdAndTeamId(matchId, teamId);

	}

	public void BatsmanScoreUpdate(LiveUpdateRequest request) {
		LiveUpdate liveUpdate = request.getLiveUpdate();
		// Updating PlayerScore Table for Batsman
		PlayerScore playerScore = playerScoreRepository.findPlayer(liveUpdate.getBatsman_id(),
				liveUpdate.getMatch_id());

		// BAll faced column update on playerScore table
		int ballFaced = playerScore.getBallFaced();
		if ((liveUpdate.getBall_type().equalsIgnoreCase("Wb"))) {
			playerScore.setBallFaced(ballFaced);
		} else {
			playerScore.setBallFaced(ballFaced++);
		}

		// Batsman out
		if (liveUpdate.getBatsman_out() == true) {
			playerScore.setBatsmenOut(true);
		}

		// no of fours
		int fours = playerScore.getNoOfFours();
		if (liveUpdate.getRuns() == 4) {
			if (liveUpdate.getBall_type().equalsIgnoreCase("wb") || liveUpdate.getBall_type().equalsIgnoreCase("nb")
					|| liveUpdate.getBall_type().equalsIgnoreCase("bye")
					|| liveUpdate.getBall_type().equalsIgnoreCase("lb")) {
				playerScore.setNoOfFours(fours);
			} else {
				playerScore.setNoOfFours(fours++);

			}
		}
		if (liveUpdate.getRuns() == 5 && liveUpdate.getBall_type().equalsIgnoreCase("nb")) {
			playerScore.setNoOfFours(fours++);
		}

		// no of sixes
		int sixes = playerScore.getNoOfSixes();
		if (liveUpdate.getRuns() == 6) {
			if (liveUpdate.getBall_type().equalsIgnoreCase("wb") || liveUpdate.getBall_type().equalsIgnoreCase("bye")
					|| liveUpdate.getBall_type().equalsIgnoreCase("lb")) {
				playerScore.setNoOfFours(sixes);
			} else {
				playerScore.setNoOfFours(sixes++);

			}
		}
		if (liveUpdate.getRuns() == 7 && liveUpdate.getBall_type().equalsIgnoreCase("nb")) {
			playerScore.setNoOfFours(fours++);
		}

		// run scored
		int previousScore = playerScore.getRunScored();
		if (liveUpdate.getBall_type().equalsIgnoreCase("wb") || liveUpdate.getBall_type().equalsIgnoreCase("bye")
				|| liveUpdate.getBall_type().equalsIgnoreCase("lb")
				|| liveUpdate.getBall_type().equalsIgnoreCase("nb")) {
			playerScore.setRunScored(previousScore);
		} else {
			playerScore.setRunScored(previousScore + liveUpdate.getRuns());

		}
		if (liveUpdate.getBall_type().equalsIgnoreCase("nb") && liveUpdate.getRuns() > 1) {
			playerScore.setRunScored(previousScore + liveUpdate.getRuns() - 1);

		}

		// batsman out
		if (!(liveUpdate.getWicket_reason() == null)) {
			playerScore.setBatsmenOut(true);
		}
	}

}
