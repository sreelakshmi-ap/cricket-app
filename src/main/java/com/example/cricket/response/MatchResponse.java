package com.example.cricket.response;

import java.time.LocalDate;

public class MatchResponse {
	
	String match_name;
	int ground_id;
	String status;
	LocalDate match_date;
	String team_1_name;
	String team_2_name;
	String stopped_reason;
	int team_1_score;
	int team_2_score;
	int team_1_wicket;
	int team_2_wicket;
	float team_1_overs;
	float team_2_overs;
	public MatchResponse(String match_name, int ground_id, String status, LocalDate match_date, String team_1_name,
			String team_2_name, String stopped_reason, int team_1_score, int team_2_score, int team_1_wicket,
			int team_2_wicket, float team_1_overs, float team_2_overs) {
		super();
		this.match_name = match_name;
		this.ground_id = ground_id;
		this.status = status;
		this.match_date = match_date;
		this.team_1_name = team_1_name;
		this.team_2_name = team_2_name;
		this.stopped_reason = stopped_reason;
		this.team_1_score = team_1_score;
		this.team_2_score = team_2_score;
		this.team_1_wicket = team_1_wicket;
		this.team_2_wicket = team_2_wicket;
		this.team_1_overs = team_1_overs;
		this.team_2_overs = team_2_overs;
	}
	
	
	public MatchResponse(String match_name, int ground_id, String status, LocalDate match_date, String team_1_name,
			String team_2_name, String stopped_reason) {
		super();
		this.match_name = match_name;
		this.ground_id = ground_id;
		this.status = status;
		this.match_date = match_date;
		this.team_1_name = team_1_name;
		this.team_2_name = team_2_name;
		this.stopped_reason = stopped_reason;
	}


	public MatchResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMatch_name() {
		return match_name;
	}
	public void setMatch_name(String match_name) {
		this.match_name = match_name;
	}
	public int getGround_id() {
		return ground_id;
	}
	public void setGround_id(int ground_id) {
		this.ground_id = ground_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getMatch_date() {
		return match_date;
	}
	public void setMatch_date(LocalDate match_date) {
		this.match_date = match_date;
	}
	public String getTeam_1_name() {
		return team_1_name;
	}
	public void setTeam_1_name(String team_1_name) {
		this.team_1_name = team_1_name;
	}
	public String getTeam_2_name() {
		return team_2_name;
	}
	public void setTeam_2_name(String team_2_name) {
		this.team_2_name = team_2_name;
	}
	public String getStopped_reason() {
		return stopped_reason;
	}
	public void setStopped_reason(String stopped_reason) {
		this.stopped_reason = stopped_reason;
	}
	public int getTeam_1_score() {
		return team_1_score;
	}
	public void setTeam_1_score(int team_1_score) {
		this.team_1_score = team_1_score;
	}
	public int getTeam_2_score() {
		return team_2_score;
	}
	public void setTeam_2_score(int team_2_score) {
		this.team_2_score = team_2_score;
	}
	public int getTeam_1_wicket() {
		return team_1_wicket;
	}
	public void setTeam_1_wicket(int team_1_wicket) {
		this.team_1_wicket = team_1_wicket;
	}
	public int getTeam_2_wicket() {
		return team_2_wicket;
	}
	public void setTeam_2_wicket(int team_2_wicket) {
		this.team_2_wicket = team_2_wicket;
	}
	public float getTeam_1_overs() {
		return team_1_overs;
	}
	public void setTeam_1_overs(float team_1_overs) {
		this.team_1_overs = team_1_overs;
	}
	public float getTeam_2_overs() {
		return team_2_overs;
	}
	public void setTeam_2_overs(float team_2_overs) {
		this.team_2_overs = team_2_overs;
	}
	
	
}
