package com.example.cricket.response;

public class StandingResponse {
	int team_id;
	String teamName;
	int matchs;
	Integer wins;
	Integer losses;
	Integer points;
	Integer NR;
	double net_run_rate;
	
	public StandingResponse(int team_id,String teamName, int matchs, Integer wins, Integer losses, Integer points, Integer nR,
			double net_run_rate) {
		super();
		this.team_id=team_id;
		this.teamName = teamName;
		this.matchs = matchs;
		this.wins = wins;
		this.losses = losses;
		this.points = points;
		NR = nR;
		this.net_run_rate = net_run_rate;
	}

	public StandingResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getMatchs() {
		return matchs;
	}

	public void setMatchs(int matchs) {
		this.matchs = matchs;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getNR() {
		return NR;
	}

	public void setNR(Integer nR) {
		NR = nR;
	}

	public double getNet_run_rate() {
		return net_run_rate;
	}

	public void setNet_run_rate(double net_run_rate) {
		this.net_run_rate = net_run_rate;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	
	
	
	
	

}
