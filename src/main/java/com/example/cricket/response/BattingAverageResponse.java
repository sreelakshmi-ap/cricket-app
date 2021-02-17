package com.example.cricket.response;

public class BattingAverageResponse {
       
	int player_id;
	String player_name;
	Float batting_average;
	
	
	public BattingAverageResponse(int player_id, String player_name, Float batting_average) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.batting_average = batting_average;
	}


	public BattingAverageResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getPlayer_id() {
		return player_id;
	}


	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}


	public String getPlayer_name() {
		return player_name;
	}


	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}


	public Float getBatting_average() {
		return batting_average;
	}


	public void setBatting_average(Float batting_average) {
		this.batting_average = batting_average;
	}
	
	
}
