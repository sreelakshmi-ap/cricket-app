package com.example.cricket.response;

import org.springframework.http.HttpStatus;

import com.example.cricket.model.Tournament;

public class ViewTournamentResponse {
	
	Tournament tournament;
	HttpStatus responseStatus;
	
	
	
	public ViewTournamentResponse() {
		super();
	}



	public ViewTournamentResponse(Tournament tournament, HttpStatus responseStatus) {
		super();
		this.tournament = tournament;
		this.responseStatus = responseStatus;
	}



	public Tournament getTournament() {
		return tournament;
	}



	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}



	public HttpStatus getResponseStatus() {
		return responseStatus;
	}



	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
	

}
