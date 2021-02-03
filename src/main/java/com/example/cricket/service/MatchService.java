package com.example.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Matchs;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.response.InningsResponse;

@Service
public class MatchService {
	
	@Autowired
	MatchRepository matchRepository;
	
	//Set Innings API
	
	public InningsResponse setInnings(int match_id,int innings)
	{
		Matchs matchs=matchRepository.findById(match_id).get();
		matchs.setInnings(innings);
		matchRepository.save(matchs);
		return new InningsResponse(match_id,innings,"Innings Added",HttpStatus.OK);
	}

}
