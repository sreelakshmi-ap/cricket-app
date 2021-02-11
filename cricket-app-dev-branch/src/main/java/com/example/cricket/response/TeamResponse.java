package com.example.cricket.response;

import org.springframework.http.HttpStatus;

import com.example.cricket.model.Team;

public class TeamResponse {
	
	Team team;
	
	String message;
	
	HttpStatus responseStatus;
	
	

	public TeamResponse() {
		super();
	}



	public TeamResponse(Team team, String message, HttpStatus responseStatus) {
		super();
		this.team = team;
		this.message = message;
		this.responseStatus = responseStatus;
	}



	public Team getTeam() {
		return team;
	}



	public void setTeam(Team team) {
		this.team = team;
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
