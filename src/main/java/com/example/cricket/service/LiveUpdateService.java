package com.example.cricket.service;

import java.util.ArrayList;
import java.util.List;

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
	LiveUpdateRepository liveUpdateRepo;

	@Autowired
	TeamScoreRepository teamScoreRepo;

	@Autowired
	PlayerScoreRepository playerScoreRepo;

	public void liveUpdate(LiveUpdate liveUpdate) {/// only use live update class

//		LiveUpdate liveUpdate = liveReq.getLiveUpdate();
		System.out.println(liveUpdate.getTeam_id());
		LiveUpdate liveUpdateTable = LiveUpdateTable(liveUpdate);
		TeamScore teamScoreTable = TeamScoreUpdateValues(liveUpdate);
		String response = PlayerScoreUpdateValues(liveUpdate);
	}

	// data that are saved in live_update table in database
	public LiveUpdate LiveUpdateTable(LiveUpdate liveUpdate) {

//		LiveUpdate liveUpdate = new LiveUpdate();
//		liveUpdate = liveReq.getLiveUpdate();
		return liveUpdateRepo.save(liveUpdate);

	}

	// data to update in team Score table in database
	public TeamScore TeamScoreUpdateValues(LiveUpdate liveUpdate) {
//		LiveUpdate liveUpdate = liveReq.getLiveUpdate();
		System.out.println("--------------->" + liveUpdate.getTeam_id());
		TeamScore data = teamScoreRepo.findByMatchIdAndTeamId(liveUpdate.getTeam_id(), liveUpdate.getMatch_id());
		System.out.println(data.getTeamId() + "\n" + data.getMatchId());
		int runs = data.getRuns() + liveUpdate.getRuns();
		int balls = liveUpdate.getBallno();
		float over = overs(balls);
		float currentRR = CurrentRunRate(runs, balls);
		int wicket = data.getWickets();
		int extra = data.getExtraRuns();

		// doubt ----->
		if (!data.isBattingOrder()) {
			float requiredRR = RequiredRunRate(10, 5);
		}
		// <---------------
		if (!liveUpdate.getWicket_reason().isEmpty()) {// when there is wicket reason ..wicket count incremented
			wicket = wicket + 1;
		}

		if (!liveUpdate.getBall_type().equalsIgnoreCase("good ball")) { // when there is wicket reason ..wicket count
																		// incremented
			extra = extra + 1;

		}

		data.setCurrentRunRate(currentRR);
		data.setRequiredRunRate(0); // doubt---
		data.setRuns(runs);
		data.setNoOfBalls(balls);
		data.setOvers(over);
		data.setExtraRuns(extra);
		data.setWickets(wicket);

		return teamScoreRepo.save(data);
	}

	// updating the player score data table

	public String PlayerScoreUpdateValues(LiveUpdate liveUpdate) {

//		LiveUpdate liveUpdate = liveReq.getLiveUpdate();

//<----------------------------- Batsman Data update in player Score data table------------------------------------>

		PlayerScore BatsmanData = playerScoreRepo.findByTeamIdAndMatchId(liveUpdate.getTeam_id(),
				liveUpdate.getMatch_id(), liveUpdate.getBatsman_id());

		int ballFaced = BatsmanData.getBallFaced();
		boolean batsmanOut = BatsmanData.isBatsmenOut();
		boolean batsmanBatting = BatsmanData.isBatting();
		boolean batsmanOnCrease = BatsmanData.isOnCrease();
		int noOfFours = BatsmanData.getNoOfFours();
		int noOfSix = BatsmanData.getNoOfSixes();
		int runScored = BatsmanData.getRunScored();
		float strikeRate = BatsmanData.getBatsmenSr();
		// ball faced
		if (!(liveUpdate.getBall_type().equalsIgnoreCase("wide"))) {
			ballFaced = ballFaced + 1;
		}

		if (!(liveUpdate.getWicket_reason().equalsIgnoreCase("no ball"))) {
			batsmanOut = true;
			batsmanBatting = false;
			batsmanOnCrease = false;

		}

		if (liveUpdate.getRuns() % 2 != 0 && (liveUpdate.getBall_type().equalsIgnoreCase("good ball")
				|| liveUpdate.getBall_type().equalsIgnoreCase("bye")
				|| liveUpdate.getBall_type().equalsIgnoreCase("leg bye"))) {
			batsmanOnCrease = false;
		}

		// No of fours calculation
		if (liveUpdate.getRuns() == 4 && liveUpdate.getBall_type().equalsIgnoreCase("good ball")) {
			noOfFours = noOfFours + 1;
		}
		if (liveUpdate.getRuns() == 5 && liveUpdate.getBall_type().equalsIgnoreCase("no ball")) {
			noOfFours = noOfFours + 1;
		}

		// No of six calculation
		if (liveUpdate.getRuns() == 6 && liveUpdate.getBall_type().equalsIgnoreCase("good ball")) {
			noOfSix = noOfSix + 1;
		}
		if (liveUpdate.getRuns() == 7 && liveUpdate.getBall_type().equalsIgnoreCase("no ball")) {
			noOfSix = noOfSix + 1;
		}

		// calculation of player runs
		if (liveUpdate.getBall_type().equalsIgnoreCase("good ball")) {
			runScored = runScored + liveUpdate.getRuns();
		}
		if (liveUpdate.getBall_type().equalsIgnoreCase("no ball")) {
			runScored = runScored + liveUpdate.getRuns() - 1;
		}

		strikeRate = strikerate(runScored, ballFaced);

		// setters for Batsman data
		BatsmanData.setBallFaced(ballFaced);
		BatsmanData.setBatsmenOut(batsmanOut);
		BatsmanData.setBatsmenSr(strikeRate);
		BatsmanData.setNoOfFours(noOfFours);
		BatsmanData.setNoOfSixes(noOfSix);
		BatsmanData.setRunScored(runScored);

		playerScoreRepo.save(BatsmanData);

//<----------------------------- Bowler data update in player Score data table------------------------------------>
		PlayerScore BowlerData = playerScoreRepo.findByTeamIdAndMatchId(liveUpdate.getTeam_id(),
				liveUpdate.getMatch_id(), liveUpdate.getBowler_id());

		float NoOfOvers = BowlerData.getNoOfOversBowled();
		int runs = BowlerData.getRuns();
		float economyRate = Economy(OverToBalls(NoOfOvers), runs);
		int BowlerWicket = BowlerData.getWickets();
		int BowlerMaiden = BowlerData.getNoOfMaidens();

		if (!(liveUpdate.getBall_type().equalsIgnoreCase("no ball")
				|| liveUpdate.getBall_type().equalsIgnoreCase("wide"))) {
			NoOfOvers = (float) (NoOfOvers + 0.1);
			if (((int) (NoOfOvers * 10) % 10) == 6) {
				int ballCount = OverToBalls(NoOfOvers);
				NoOfOvers = (float) (ballCount / 6);

				// update maiden over in playerScore
				BowlerMaiden = maidenOver(BowlerData.getTeamId(), BowlerData.getMatchId(), BowlerData.getPlayerId(),
						BowlerData.getNoOfMaidens());
			}

		}

		if ((liveUpdate.getBall_type().equalsIgnoreCase("no ball") || liveUpdate.getBall_type().equalsIgnoreCase("wide")
				|| liveUpdate.getBall_type().equalsIgnoreCase("good ball"))) {
			runs = runs + liveUpdate.getRuns();

//			if (liveUpdate.getBall_type().equalsIgnoreCase("legbye") || liveUpdate.getBall_type().equalsIgnoreCase("bye")) {
//				runs = runs + 1;
//
//			} else {
//				runs = runs + liveUpdate.getRuns();
//			}

		}

		if (!(liveUpdate.getWicket_reason().equalsIgnoreCase("run out"))) {
			BowlerWicket = BowlerWicket + 1;

		}

		// setters for Bowler Data
		BowlerData.setEconomyRate(economyRate);
		BowlerData.setNoOfMaidens(BowlerMaiden);
		BowlerData.setNoOfOversBowled(NoOfOvers);
		BowlerData.setRuns(runs);
		BowlerData.setWickets(BowlerWicket);

		playerScoreRepo.save(BowlerData);

		return "Player Score Table Updated!!";

	}

	// function to calculate different fields

	// 1. CurrentRunRate

	public float CurrentRunRate(int runs, int balls) {
		float runrate = (float) (runs * 6) / balls;
		return runrate;
	}

	// 2.RequiredRunRate

	public float RequiredRunRate(int runsToWin, int balls) {
		float RequiredRate = (float) (runsToWin * 6) / balls;
		return RequiredRate;
	}

	// 3. overs

	public float overs(int balls) {
		int over = balls / 6;
		int overballs = balls % 6;
		float TotalOvers = (float) (over + (overballs * 0.1));
		return TotalOvers;
	}

	// 4. Strike Rate

	public float strikerate(int runs, int balls) {
		float Strikerate;
		Strikerate = ((float) (runs) / balls) * 100;
		return Strikerate;
	}

	// 5. Overs To Ball

	public int OverToBalls(float overs) {
		int balls = 0;
		balls = 6 * (int) (overs);
		balls = balls + ((int) (overs * 10) % 10);

		return balls;
	}

	// 6. economy rate

	public float Economy(int runs, int balls) {
		float economy = (float) (runs * 6) / balls;
		return economy;
	}

	public int maidenOver(int teamId, int matchId, int bowlerId, int maidenCount) {
		List<LiveUpdate> BowlingStatus = liveUpdateRepo.findBowlingStatus(teamId, matchId, bowlerId);
		List<LiveUpdate> sixBalls = new ArrayList<>();
		int totalRows = BowlingStatus.size();
		System.out.println(totalRows);
		int index = totalRows - 1;
		LiveUpdate lastRow = BowlingStatus.get(index); // doubt
		int finalBallOfOver = lastRow.getBallno();
		int lastBall = finalBallOfOver;
		System.out.println(lastBall);

		int ball = finalBallOfOver;
		while (ball > (lastBall - 6)) {
			sixBalls.add(BowlingStatus.get(index)); // doubt
			index = index - 1;
			if (index < 0) {
				break;
			}
			lastRow = BowlingStatus.get(index);
			finalBallOfOver = lastRow.getBallno();
			ball = finalBallOfOver;
			System.out.println("finalballOfover===   " + ball);
			System.out.println("ball===   " + ball);

		}
		if (sixBalls.size() > 6) {
			return maidenCount;
		}

		else {
			int count = 0;
			for (LiveUpdate runs : sixBalls) {
				if (runs.getRuns() == 0) {
					count++;
				} else {
					count = -2;
					break;
				}
			}

			if (count == 6) {
				maidenCount++;

			}
		}

		return maidenCount;

	}

}
