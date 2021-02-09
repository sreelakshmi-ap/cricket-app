package com.example.cricket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cricket.model.LiveUpdate;
import com.example.cricket.model.Matchs;
import com.example.cricket.model.PlayerScore;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.LiveUpdateRepository;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.request.LiveUpdateRequest;
import com.example.cricket.response.MainResponse;

@Service
public class LiveUpdateService {
	@Autowired
	LiveUpdateRepository liveUpdateRepository;
	
	@Autowired
	 private MatchRepository matchRepository;
	
	@Autowired
	TournamentRepo tournamentRepo;
	
	@Autowired
	TeamScoreRepository teamScoreRepository;
	
	@Autowired 
	PlayerScoreRepository playerScoreRepo;
	

	public ResponseEntity<?> UpdateLiveScore(LiveUpdateRequest liveReq) {
		
		Optional<Matchs> currentMatch = matchRepository.findByMatchId(liveReq.getLiveUpdate().getMatch_id());
		
		
		
        if(currentMatch.isPresent())
        {
        	int TotalOvers=tournamentRepo.findOversByTournamentId(currentMatch.get().getTournamentId());
    		
    		int wickets=teamScoreRepository.FindWicket(currentMatch.get().getMatch_id());
    		
    		int Target=teamScoreRepository.FindTarget(currentMatch.get().getMatch_id());
    		
    		int CurrentRuns=teamScoreRepository.CurrentRun(currentMatch.get().getMatch_id());
    		
    		int TotalRuns; //Total Run For Single Ball
    		
    		if (currentMatch.get().getStatus().equals("Live"))
    		{
    			if (currentMatch.get().getInnings() == 1) {
            		
            		
            		if(TotalOvers*6==liveReq.getLiveUpdate().getBallno()||wickets==10)
            		{
            			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Innings Over", ""));
            			
            		}
            		
            		else
            		{
            			if(liveReq.getLiveUpdate().getBall_type().isEmpty())
                    	{
                    		liveReq.getLiveUpdate().setBall_type("Good ball");
                    	}
            			
            			
                    	liveUpdateRepository.save(liveReq.getLiveUpdate());
                    	
                    	TeamScoreUpdateValues(liveReq,currentMatch.get().getInnings());
            			
            			PlayerScoreUpdateValues(liveReq);
                    	
                    	return ResponseEntity.status(HttpStatus.OK).body(new LiveUpdateRequest(liveReq.getLiveUpdate()));
            		}



                } 
    			
    			
    			else if (currentMatch.get().getInnings() == 2) {
                	
                	if(TotalOvers*6==liveReq.getLiveUpdate().getBallno()||wickets==10||CurrentRuns>Target)
            		{
                		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Innings Over", ""));
            		}
                	
                	else
                	{
                		if(liveReq.getLiveUpdate().getBall_type().isEmpty())
                    	{
                    		liveReq.getLiveUpdate().setBall_type("Good ball");
                    	}
                		
                		TeamScoreUpdateValues(liveReq,currentMatch.get().getInnings());
                		
                		PlayerScoreUpdateValues(liveReq);
                    	
                    	liveUpdateRepository.save(liveReq.getLiveUpdate());
                    	return ResponseEntity.status(HttpStatus.OK).body(new LiveUpdateRequest(liveReq.getLiveUpdate()));
                	}


                }
    		}
    		
        	
        
        }
        
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Match ID not found", ""));
		//return null;
		
	}
	
	
	public void TeamScoreUpdateValues(LiveUpdateRequest liveReq,int innings)
	{
		
		int TotalRuns=liveReq.getLiveUpdate().getRuns();
		
		LiveUpdate liveUpdate = liveReq.getLiveUpdate();
		
		
		TeamScore teamScoreRepo = teamScoreRepository.findByMatchIdAndTeamId(liveUpdate.getMatch_id(),liveUpdate.getTeam_id());
		
		if(liveReq.getLiveUpdate().getBall_type().equalsIgnoreCase("Wide")||liveReq.getLiveUpdate().getBall_type().equalsIgnoreCase("No ball"))
		{
			TotalRuns+=1;
		}
		
		int runs = teamScoreRepo.getRuns()+TotalRuns;
		int balls =liveUpdate.getBallno();
		float over = overs(balls);
		int wicket = teamScoreRepo.getWickets();
		int extra = teamScoreRepo.getExtraRuns();
		
		
		if(!(liveUpdate.getBall_type().equalsIgnoreCase("Good ball")))
		{
			if((liveUpdate.getBall_type().equalsIgnoreCase("No Ball"))||((liveUpdate.getBall_type().equalsIgnoreCase("Wide")&&(liveUpdate.getRuns()==0))))
			{
				extra+=1;
			}
			
			else
			{
				extra=extra+TotalRuns;
			}
			
		}
		
		if(liveReq.getWicketId()!=0)
		{
			//if(wicket)
			wicket+=1;
		}
		
		if(innings==1)
		{
			float CurrentRunRate=CurrentRunRate(runs, balls);
			teamScoreRepo.setCurrentRunRate(CurrentRunRate);
		}
		
		if(innings==2)
		{
			Optional<Matchs> currentMatch = matchRepository.findByMatchId(liveReq.getLiveUpdate().getMatch_id());
			int Target=teamScoreRepository.FindTarget(currentMatch.get().getMatch_id());
			int RunsToWin=Target-runs;
			int TotalBalls=tournamentRepo.findOversByTournamentId(currentMatch.get().getTournamentId())*6;
			int BallsRemaining=TotalBalls-balls;
			
			float RequiredRunRate=RequiredRunRate(RunsToWin, BallsRemaining);
			teamScoreRepo.setRequiredRunRate(RequiredRunRate);
		}
		
		teamScoreRepo.setRuns(runs);
		teamScoreRepo.setWickets(wicket);
		teamScoreRepo.setExtraRuns(extra);
		teamScoreRepo.setNoOfBalls(balls);
		teamScoreRepo.setOvers(over);
		
		teamScoreRepository.save(teamScoreRepo);
		
		
		
	}
	
	
	public void PlayerScoreUpdateValues(LiveUpdateRequest liveReq)
	{
		LiveUpdate liveUpdate = liveReq.getLiveUpdate();
		
		PlayerScore BatsmanData = playerScoreRepo.findByTeamIdAndMatchId(liveUpdate.getMatch_id(),liveUpdate.getTeam_id(), liveUpdate.getBatsman_id());
		
		int ballFaced =  BatsmanData.getBallFaced();
		boolean batsmanOut = BatsmanData.isBatsmenOut();
		boolean batsmanBatting = BatsmanData.isBatting();
		boolean batsmanOnCrease = BatsmanData.isOnCrease();
		int noOfFours = BatsmanData.getNoOfFours();
		int noOfSix = BatsmanData.getNoOfSixes();
		int runScored = BatsmanData.getRunScored();
		//float strikeRate = BatsmanData.getBatsmenSR();
		
		if(liveReq.getWicketId()!=0)
		{
			PlayerScore OutbatsmanData = playerScoreRepo.findByTeamIdAndMatchId(liveUpdate.getMatch_id(),liveUpdate.getTeam_id(), liveReq.getWicketId());
			OutbatsmanData.setBatsmenOut(true);
			playerScoreRepo.save(OutbatsmanData);
		}
		
		if(liveUpdate.getRuns() == 4 && (liveUpdate.getBall_type().equalsIgnoreCase("Good ball")||(liveUpdate.getBall_type().equalsIgnoreCase("No Ball")))) {
			noOfFours = noOfFours+1;
		}
		
		if(liveUpdate.getRuns() == 6 && (liveUpdate.getBall_type().equalsIgnoreCase("Good ball")||(liveUpdate.getBall_type().equalsIgnoreCase("No Ball")))) {
			noOfSix = noOfSix+1;
		}
		
		if(liveUpdate.getBall_type().equalsIgnoreCase("No ball")||liveUpdate.getBall_type().equalsIgnoreCase("Good ball"))
		{
			System.out.println(runScored);
			runScored=liveUpdate.getRuns()+runScored;
		}
		
		if(!(liveUpdate.getBall_type().equalsIgnoreCase("No ball")||(liveUpdate.getBall_type().equalsIgnoreCase("Wide"))))
		{
			ballFaced+=1;
		}
		
		
		if (liveUpdate.getRuns() % 2 != 0 && (liveUpdate.getBall_type().equalsIgnoreCase("Good ball")
				|| liveUpdate.getBall_type().equalsIgnoreCase("bye")
				|| liveUpdate.getBall_type().equalsIgnoreCase("leg bye"))) {
			batsmanOnCrease = false;
		}
		float Strikerate;
		if(ballFaced>0)
		{
			Strikerate=strikerate(runScored,ballFaced);
		}
		
		else
		{
			Strikerate=0;
		}
		
		
		System.out.println(Strikerate);
		
		
		
		//Bowlers Data
		
		int BowlingTeamId=teamScoreRepository.GetBowlingTeamId(liveUpdate.getMatch_id());
		PlayerScore BowlerData = playerScoreRepo.findByTeamIdAndMatchId(liveUpdate.getMatch_id(),BowlingTeamId, liveUpdate.getBowler_id());
		
		float NoOfOvers = BowlerData.getNoOfOversBowled();
		
		int runs=BowlerData.getRuns()+liveUpdate.getRuns();
		
		int TotalBalls=OverToBalls((float)NoOfOvers);
		//int TotalBalls=12;
		
		int wickets=BowlerData.getWickets();
		
		if(!(liveUpdate.getBall_type().equalsIgnoreCase("no ball") || liveUpdate.getBall_type().equalsIgnoreCase("wide"))) 
		{
			TotalBalls+=1;
			NoOfOvers=overs(TotalBalls);
			System.out.println(NoOfOvers);
		}
		
		//Else means For Wide and No balls Increment Run
		else
		{
			runs+=1;
		}
		
		
		if(liveReq.getWicketId()!=0)
		{
			if(!liveReq.getLiveUpdate().getWicket_reason().equalsIgnoreCase("Run Out"))
			{
				wickets+=1;
			}
			
		}
		
		float economy=Economy(runs, TotalBalls);
		
		BatsmanData.setBallFaced(ballFaced);
		
		//BatsmanData.setBatsmenOut(batsmanOut);
		
		BatsmanData.setNoOfFours(noOfFours);
		
		BatsmanData.setNoOfSixes(noOfSix);
		
		BatsmanData.setBatting(batsmanBatting);
		
		BatsmanData.setOnCrease(batsmanOnCrease);
		
		BatsmanData.setRunScored(runScored);
		
		BatsmanData.setBowling(false);
		
		BatsmanData.setBatsmenSR(Strikerate);
		
		
		BowlerData.setEconomyRate(economy);
		BowlerData.setNoOfOversBowled(NoOfOvers);
		BowlerData.setRuns(runs);
		BowlerData.setWickets(wickets);
		BowlerData.setBatting(false);
		
		playerScoreRepo.save(BatsmanData);
		
		playerScoreRepo.save(BowlerData);
		
		
		
	}
	
	
	public int nextBall(String balltype,int previous_ballnumber)
	{
		int ballnumber=previous_ballnumber;
		if(balltype.equals("No Ball")&&(balltype.equals("Wide")))
		{
			//ballnumber+=1;
			return ballnumber;
		}
		
		return ballnumber++;
	}
	
	public float CurrentRunRate(int runs,int balls)
	{
		float runrate=(float)(runs*6)/balls;
		return runrate;
	}
	
	float strikerate(int runs,int balls) 
	{ 
	    float Strikerate; 
	    Strikerate =((float)(runs) / balls) * 100; 
	    return Strikerate; 
	}
	
	public float overs(int balls)
    {
		int over = balls / 6;
        int overballs = balls % 6;
        float TotalOvers = (float) ( over + ( overballs * 0.1 ));
        return TotalOvers; 
    }
	
	public float Economy(int runs,int balls)
	{
		float economy=(float)(runs*6)/balls;
		return economy;
	}
	
	public float RequiredRunRate(int runsToWin,int balls)
	{
		float RequiredRate=(float)(runsToWin*6)/balls;
		return RequiredRate;
	}
	
	public int OverToBalls(float overs) {
		int balls = 0;
		balls = 6*(int)(overs);
		balls = balls + ((int)(overs * 10) % 10);
		
		return balls;
	}
	
	
//	public ResponseEntity<?> getMaidenOverDetails(int matchId,int bowlerId)
//	{
//		return null;
//	}
//	
//	public ResponseEntity<?> CheckMaidenOvers(int matchId,int teamId,int bowlerId)
//	{
//		return null;
//	}
	
	
	
	
}
