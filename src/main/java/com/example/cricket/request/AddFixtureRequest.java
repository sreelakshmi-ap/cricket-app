package com.example.cricket.request;

import java.util.List;

import com.example.cricket.model.Matchs;

public class AddFixtureRequest {
	
	List<Matchs> matchsList;

	public AddFixtureRequest(List<Matchs> matchsList) {
		super();
		this.matchsList = matchsList;
	}

	public AddFixtureRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Matchs> getMatchsList() {
		return matchsList;
	}

	public void setMatchsList(List<Matchs> matchsList) {
		this.matchsList = matchsList;
	}
	
	
	
	

}
