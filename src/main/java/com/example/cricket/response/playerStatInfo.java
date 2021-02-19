package com.example.cricket.response;

public class playerStatInfo {
	private int playerId;
	private String playerName;
	private String playerImage;
	private int teamId;
	private String teamName;
	private String teamImage;
	private int data;
	
	public playerStatInfo() {
		
	}
	
	public playerStatInfo(int playerId, String playerName, String playerImage, int teamId, String teamName,
			String teamImage, int data) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerImage = playerImage;
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamImage = teamImage;
		this.data = data;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerImage() {
		return playerImage;
	}

	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamImage() {
		return teamImage;
	}

	public void setTeamImage(String teamImage) {
		this.teamImage = teamImage;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
	
	

}
