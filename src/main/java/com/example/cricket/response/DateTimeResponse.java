package com.example.cricket.response;

import org.springframework.http.HttpStatus;

public class DateTimeResponse {
	
	int tournamentId;
	
	String message;
	
	HttpStatus responseStatus;
	
	
	

	public DateTimeResponse() {
		super();
	}




	public DateTimeResponse(int tournamentId, String message, HttpStatus responseStatus) {
		super();
		this.tournamentId = tournamentId;
		this.message = message;
		this.responseStatus = responseStatus;
	}




	public int getTournamentId() {
		return tournamentId;
	}




	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public HttpStatus getResponseStatus() {
		return responseStatus;
	}




	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
	

}
