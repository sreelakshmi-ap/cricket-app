package com.example.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class PlayerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int playerId;
	
	@Column
	private String playerName;
	
	@Column 
	private String location;
	
	@Column 
	private long phoneNumber;
	
	@Column
	private String expertise;
	
	@Column
	private String batting;
	
	@Column
	private String bowling;
	
	@Column
	private String bowlingType;
	 
	@Column
	private String imagePath;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getBatting() {
		return batting;
	}

	public void setBatting(String batting) {
		this.batting = batting;
	}

	public String getBowling() {
		return bowling;
	}

	public void setBowling(String bowling) {
		this.bowling = bowling;
	}

	public String getBowlingType() {
		return bowlingType;
	}

	public void setBowlingType(String bowlingType) {
		this.bowlingType = bowlingType;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
