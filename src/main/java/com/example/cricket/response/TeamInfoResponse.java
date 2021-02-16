package com.example.cricket.response;

import com.example.cricket.model.Team;

public class TeamInfoResponse {
	
	String city;
	int matchs;
	Integer wins;
	Integer losses;
	Integer draw_or_cancelled;
	Integer points;
	String captain;
	public TeamInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeamInfoResponse(String city, int matchs, Integer wins, Integer losses, Integer draw_or_cancelled,
			Integer points, String captain) {
		super();
		this.city = city;
		this.matchs = matchs;
		this.wins = wins;
		this.losses = losses;
		this.draw_or_cancelled = draw_or_cancelled;
		this.points = points;
		this.captain = captain;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public Integer getDraw_or_cancelled() {
		return draw_or_cancelled;
	}
	public void setDraw_or_cancelled(Integer draw_or_cancelled) {
		this.draw_or_cancelled = draw_or_cancelled;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	
	
	
}