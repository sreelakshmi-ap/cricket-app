package com.example.cricket.response;

import java.util.List;

public class GroundResponse {

	private Object ground;
	private Object matchDetails;

	public GroundResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroundResponse(Object ground, Object matchDetails) {
		super();
		this.ground = ground;
		this.matchDetails = matchDetails;
	}

	public Object getGround() {
		return ground;
	}

	public void setGround(Object ground) {
		this.ground = ground;
	}

	public Object getMatchDetails() {
		return matchDetails;
	}

	public void setMatchDetails(Object matchDetails) {
		this.matchDetails = matchDetails;
	}

	
}
