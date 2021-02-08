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
public class LiveUpadteService {

	@Autowired
	LiveUpdateRepository liveUpdateRepo;

	@Autowired
	TeamScoreRepository teamScoreRepo;

	@Autowired
	PlayerScoreRepository playerScoreRepo;

	// data that are saved in live_update table in database

	public void LiveUpdateValues(LiveUpdateRequest liveReq) {

		LiveUpdate liveUpdate = liveReq.getLiveUpdate();
		LiveUpdate data = liveUpdateRepo.findLiveMatch(liveUpdate.getTeam_id(), liveUpdate.getMatch_id());
		data.setBall_type(liveUpdate.getBall_type());
		data.setBallno(liveUpdate.getBallno());
		data.setBatsman_id(liveUpdate.getBatsman_id());
		data.setBatsman_out(liveUpdate.getBatsman_out());
		data.setBowler_id(liveUpdate.getBowler_id());
		data.setCommentary(liveUpdate.getCommentary());
		data.setFielder_id(liveUpdate.getFielder_id());
		data.setMatch_id(liveUpdate.getMatch_id());
		data.setTeam_id(liveUpdate.getTeam_id());
		data.setRuns(liveUpdate.getRuns());
		data.setWicket_reason(liveUpdate.getWicket_reason());

	}

	// data to update in team Score table in database

	public void TeamScoreUpdateValues(LiveUpdateRequest liveReq) {
		LiveUpdate liveUpdate = liveReq.getLiveUpdate();
		TeamScore data = teamScoreRepo.findByMatchIdAndTeamId(liveUpdate.getTeam_id(), liveUpdate.getMatch_id());
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
		if (liveReq.getWicketCondition().isEmpty()) {
			wicket = wicket + 1;
		}

		if (liveReq.getExtra().isEmpty()) {
			extra = extra + 1;

		}

		data.setCurrentRunRate(currentRR);
		data.setRequiredRunRate(0); // doubt---
		data.setRuns(runs);
		data.setNoOfBalls(balls);
		data.setOvers(over);
		data.setExtraRuns(extra);
		data.setWickets(wicket);

	}

	// updating the player score data table

	public void PlayerScoreUpdateValues(LiveUpdateRequest liveReq) {

		LiveUpdate liveUpdate = liveReq.getLiveUpdate();

		// Bowler data update in player Score data table----------->

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

		if (!(liveReq.getExtra().equalsIgnoreCase("wide"))) {
			ballFaced = ballFaced + 1;
		}

		if (!(liveReq.getWicketCondition().equalsIgnoreCase("no ball"))) {
			batsmanOut = true;
			batsmanBatting = false;
			batsmanOnCrease = false;

		}

		if (liveReq.getRunScored() % 2 != 0) {
			batsmanOnCrease = false;
		}

		if (liveReq.getRunScored() == 4) {
			noOfFours = noOfFours + 1;
		}

		if (liveReq.getRunScored() == 6) {
			noOfSix = noOfSix + 1;
		}

		if (liveReq.getExtra().equalsIgnoreCase("no ball")) {
			runScored = runScored + liveReq.getRunScored();
		}

		strikeRate = strikerate(runScored, ballFaced);

		// Bowler data update in player Score data table------>

		PlayerScore BowlerData = playerScoreRepo.findByTeamIdAndMatchId(liveUpdate.getTeam_id(),
				liveUpdate.getMatch_id(), liveUpdate.getBatsman_id());

		float NoOfOvers = BowlerData.getNoOfOversBowled();
		int runs = BowlerData.getRuns();
		float economyRate = Economy(OverToBalls(NoOfOvers), runs);
		int BowlerWicket = BowlerData.getWickets();
		int BowlerMaiden = BowlerData.getNoOfMaidens();

		if (!(liveReq.getExtra().equalsIgnoreCase("no ball") || liveReq.getExtra().equalsIgnoreCase("wide"))) {
			NoOfOvers = (float) (NoOfOvers + 0.1);
			if (((int) (NoOfOvers * 10) % 10) == 6) {
				int ballCount = OverToBalls(NoOfOvers);
				NoOfOvers = (float) (ballCount / 6);
			}

		}

		if ((liveReq.getExtra().equalsIgnoreCase("no ball") || liveReq.getExtra().equalsIgnoreCase("wide"))) {
			if (liveReq.getExtra().equalsIgnoreCase("legbye") || liveReq.getExtra().equalsIgnoreCase("bye")) {
				runs = runs + 1;

			} else {
				runs = runs + liveUpdate.getRuns();
			}

		}

		if (!((liveReq.getExtra()).equalsIgnoreCase("run out"))) {
			BowlerWicket = BowlerWicket + 1;

		}
		
		
		//maiden over test....
		
		

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
		int index = totalRows-1;
		LiveUpdate lastRow =  BowlingStatus.get(index);  //doubt
		int finalBallOfOver= lastRow.getBallno();
		int lastBall = finalBallOfOver;
		System.out.println(lastBall);
		
		
		int ball =  finalBallOfOver;
		while(ball > (lastBall-6)) {
			sixBalls.add(BowlingStatus.get(index));  //doubt
			index = index-1;
			if(index<0) {
				break;
			}
			lastRow =  BowlingStatus.get(index);
			finalBallOfOver= lastRow.getBallno();
			ball =  finalBallOfOver;
			System.out.println("finalballOfover===   "+ball);
			System.out.println("ball===   "+ball);

		}
		if(sixBalls.size()>6) {
			return maidenCount;
		}
		
		else {
			int count = 0;
			for(LiveUpdate runs: sixBalls) {
				if(runs.getRuns() == 0) {
					count++;
				}
				else {
					count=-2;
					break;
				}
			}
			
			if(count == 6) {
				maidenCount++;
				
			}
		}
		
		
		
		
		
		
		return maidenCount;
		
	}

}
