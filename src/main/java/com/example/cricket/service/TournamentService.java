package com.example.cricket.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Tournament;
import com.example.cricket.repository.TournamentRepo;
import com.example.cricket.response.TournamentResponse;

@Service
public class TournamentService {
	
	@Autowired
	TournamentRepo tournamentRepo;
	
	public TournamentResponse CreateTournament(Tournament tournament)
	{
		String tournamentCode=generateRandomSpecialCharacters(6);
		tournament.setTournamentCode(tournamentCode);
		tournament.setTournamentStatus("Creating");
		tournamentRepo.save(tournament);
		return new TournamentResponse(tournament.getTournamentId(),tournament.getTournamentName(),tournament.getTournamentCode(),"Successfully Created",HttpStatus.OK);
	}
	
	
	public String generateRandomSpecialCharacters(int len){
		StringBuilder generatedOTP = new StringBuilder();
		SecureRandom secureRandom = new SecureRandom();

		try {

		    secureRandom = SecureRandom.getInstance(secureRandom.getAlgorithm());

		    for (int i = 0; i < len; i++) {
		        generatedOTP.append(secureRandom.nextInt(9));
		    }
		} catch (NoSuchAlgorithmException e) {
		    e.printStackTrace();
		}

		return generatedOTP.toString();

	}

}
