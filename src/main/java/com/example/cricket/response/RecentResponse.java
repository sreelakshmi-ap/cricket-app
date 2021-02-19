package com.example.cricket.response;

public class RecentResponse {
	int runs;
	String ballType;
	String wicketReason;

	public RecentResponse(int runs, String ballType, String wicketReason) {
		super();
		this.runs = runs;
		this.ballType = ballType;
		this.wicketReason = wicketReason;
	}

	public RecentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public String getBallType() {
		return ballType;
	}

	public void setBallType(String ballType) {
		this.ballType = ballType;
	}

	public String getWicketReason() {
		return wicketReason;
	}

	public void setWicketReason(String wicketReason) {
		this.wicketReason = wicketReason;
	}

}
