package com.example.cricket.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Tournament;
import com.example.cricket.repository.TournamentRepo;

import com.example.cricket.response.DateTimeResponse;
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
	

	public TournamentResponse AddOvers(int tournamentId,int overs)
	{
		Tournament tournament=tournamentRepo.findById(tournamentId).get();
		tournament.setOvers(overs);
		tournamentRepo.save(tournament);
		return new TournamentResponse(tournament.getTournamentId(),tournament.getTournamentName(),tournament.getTournamentCode(),"Overs Added",HttpStatus.OK);
	}
	
	public DateTimeResponse AddTimings(int tournamentId,String start_date,String start_time,String end_date,String end_time)
	{
		Tournament tournament=tournamentRepo.findById(tournamentId).get();
		LocalDate startdate=LocalDate.parse(start_date);
	
		LocalTime startTime = LocalTime.parse(start_time);
		
		LocalDate endDate=LocalDate.parse(end_date);
		
		LocalTime endTime=LocalTime.parse(end_time);
		
		
		System.out.println(tournament.getStartOfTime());
	    
		tournament.setStartDate(startdate);
		tournament.setStartOfTime(startTime);
		tournament.setEndDate(endDate);
		tournament.setEndOfTime(endTime);
		tournamentRepo.save(tournament);
		System.out.println(tournament.getStartOfTime());
		return new DateTimeResponse(tournament.getTournamentId(),"Tournament Date Time Added",HttpStatus.OK);
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
