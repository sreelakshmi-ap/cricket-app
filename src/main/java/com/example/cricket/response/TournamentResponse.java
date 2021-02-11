package com.example.cricket.response;

import org.springframework.http.HttpStatus;

public class TournamentResponse {
	
	int tournamentId;
	
	String tournamentName;
	
	String tournamentCode;
	
	String message;
	
	HttpStatus responseStatus;
	
	

	public TournamentResponse() {
		super();
	}



	



	public TournamentResponse(int tournamentId, String tournamentName, String tournamentCode, String message,
			HttpStatus responseStatus) {
		super();
		this.tournamentId = tournamentId;
		this.tournamentName = tournamentName;
		this.tournamentCode = tournamentCode;
		this.message = message;
		this.responseStatus = responseStatus;
	}







	public int getTournamentId() {
		return tournamentId;
	}



	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	
	



	public String getTournamentName() {
		return tournamentName;
	}



	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}



	public String getTournamentCode() {
		return tournamentCode;
	}



	public void setTournamentCode(String tournamentCode) {
		this.tournamentCode = tournamentCode;
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
