package com.example.cricket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket.model.BattingPartnership;
import com.example.cricket.repository.BattingPartnershipRepository;

@Service
public class BattingPartnershipService {
	
	@Autowired
	BattingPartnershipRepository partnershipRepository;
	
	public void PartnershipUpdate(int batsman1Id, int batsman2id,int matchId,int teamId,int runs,int balls,boolean status) 
	{
		
		Optional<BattingPartnership> BattingParnershipExist=partnershipRepository.PartnershipExist(batsman1Id, batsman2id,matchId);
		
		if(BattingParnershipExist.isPresent())
		{
			BattingPartnership battingPartnership=partnershipRepository.Partnership(matchId, teamId);
			
			
			int PartnershipRuns=battingPartnership.getRuns()+runs;
			
			int PartnershipBalls=battingPartnership.getBalls()+balls;
			
			battingPartnership.setBatmanOneId(batsman1Id);
			
			battingPartnership.setBatmanTwoId(batsman2id);
			
			battingPartnership.setRuns(PartnershipRuns);
			
			battingPartnership.setBalls(PartnershipBalls);
			
			battingPartnership.setStatus(status);
			
			partnershipRepository.save(battingPartnership);
		}
		
		else
		{
			BattingPartnership partnership=new BattingPartnership(matchId, teamId, batsman1Id, batsman2id, runs, balls, status);
			partnershipRepository.save(partnership);
		}
		
		
		
	}
	
//	public void BatsmanWicket(int matchId,int teamId)
//	{
//		BattingPartnership battingPartnership=partnershipRepository.Partnership(matchId, teamId);
//		
//		int PartnershipRuns=battingPartnership.getRuns()+runs;
//		
//		int PartnershipBalls=battingPartnership.getBalls()+balls;
//		
//		battingPartnership.setBatmanOneId(batsman1Id);
//		
//		battingPartnership.setBatmanTwoId(batsman2id);
//		
//		battingPartnership.setRuns(PartnershipRuns);
//		
//		battingPartnership.setBalls(PartnershipBalls);
//		battingPartnership.setStatus(false);
//		partnershipRepository.save(battingPartnership);
//	}

}
