package com.example.cricket.response;

import com.example.cricket.model.PlayersAchievements;

public class PlayerInfoResponse {
	
	String PlayerName;
	
	String PlayerPicture;
	
	String City;
	
	String Team;
	
	boolean Captain;
	
	String Role;
	
	String BattingStyle;
	
	String BowlingStyle;
	
	int Matches;
	
	int Runs;
	
	int Wickets;
	
	PlayersAchievements achievements;
	
	

	public PlayerInfoResponse() {
		super();
	}
	
	



	public PlayerInfoResponse(String playerName, String playerPicture, String city, String team, boolean captain,
			String role, String battingStyle, String bowlingStyle, int matches, int runs, int wickets,
			PlayersAchievements achievements) {
		super();
		PlayerName = playerName;
		PlayerPicture = playerPicture;
		City = city;
		Team = team;
		Captain = captain;
		Role = role;
		BattingStyle = battingStyle;
		BowlingStyle = bowlingStyle;
		Matches = matches;
		Runs = runs;
		Wickets = wickets;
		this.achievements = achievements;
	}
	
	
	
	



	public PlayerInfoResponse(String playerName, String playerPicture, String city, String team, boolean captain,
			String role, String battingStyle, String bowlingStyle, int matches, int runs, int wickets) {
		super();
		PlayerName = playerName;
		PlayerPicture = playerPicture;
		City = city;
		Team = team;
		Captain = captain;
		Role = role;
		BattingStyle = battingStyle;
		BowlingStyle = bowlingStyle;
		Matches = matches;
		Runs = runs;
		Wickets = wickets;
	}





	public String getPlayerName() {
		return PlayerName;
	}



	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}



	public String getPlayerPicture() {
		return PlayerPicture;
	}



	public void setPlayerPicture(String playerPicture) {
		PlayerPicture = playerPicture;
	}



	public String getCity() {
		return City;
	}



	public void setCity(String city) {
		City = city;
	}



	public String getTeam() {
		return Team;
	}



	public void setTeam(String team) {
		Team = team;
	}



	public boolean isCaptain() {
		return Captain;
	}



	public void setCaptain(boolean captain) {
		Captain = captain;
	}



	public String getRole() {
		return Role;
	}



	public void setRole(String role) {
		Role = role;
	}



	public String getBattingStyle() {
		return BattingStyle;
	}



	public void setBattingStyle(String battingStyle) {
		BattingStyle = battingStyle;
	}



	public String getBowlingStyle() {
		return BowlingStyle;
	}



	public void setBowlingStyle(String bowlingStyle) {
		BowlingStyle = bowlingStyle;
	}



	public int getMatches() {
		return Matches;
	}



	public void setMatches(int matches) {
		Matches = matches;
	}



	public int getRuns() {
		return Runs;
	}



	public void setRuns(int runs) {
		Runs = runs;
	}



	public int getWickets() {
		return Wickets;
	}



	public void setWickets(int wickets) {
		Wickets = wickets;
	}



	public PlayersAchievements getAchievements() {
		return achievements;
	}



	public void setAchievements(PlayersAchievements achievements) {
		this.achievements = achievements;
	}
	
	
	
	
	

}
