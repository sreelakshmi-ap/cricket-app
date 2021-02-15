package com.example.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teamPlayer")
public class TeamPlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamPlayerId;

    @Column
    private int teamId;

    @Column
    private int playerId;

    @Column
    private String designation;
    
    @Column
    int runs;
    
    @Column
    int hundreds;
    
    @Column
    int fifties;
    
    @Column
    int fours;
    
    @Column
    int sixes;
    
    @Column
    int wickets;
    
    @Column
    int five_wickets_hauls;
    
    
    
    

    
	public int getFive_wickets_hauls() {
		return five_wickets_hauls;
	}
	public void setFive_wickets_hauls(int five_wickets_hauls) {
		this.five_wickets_hauls = five_wickets_hauls;
	}
	
	public TeamPlayerEntity(int teamPlayerId, int teamId, int playerId, String designation, int runs, int hundreds,
			int fifties, int fours, int sixes, int wickets, int five_wickets_hauls) {
		super();
		this.teamPlayerId = teamPlayerId;
		this.teamId = teamId;
		this.playerId = playerId;
		this.designation = designation;
		this.runs = runs;
		this.hundreds = hundreds;
		this.fifties = fifties;
		this.fours = fours;
		this.sixes = sixes;
		this.wickets = wickets;
		this.five_wickets_hauls = five_wickets_hauls;
	}
	
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getHundreds() {
		return hundreds;
	}
	
	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}
	public int getFifties() {
		return fifties;
	}
	public void setFifties(int fifties) {
		this.fifties = fifties;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	
	
	public TeamPlayerEntity() {

    }
    public TeamPlayerEntity(int teamId, int playerId, String designation) {
        super();
        this.teamId = teamId;
        this.playerId = playerId;
        this.designation = designation;
    }

    public int getTeamPlayerId() {
        return teamPlayerId;
    }

    public void setTeamPlayerId(int teamPlayerId) {
        this.teamPlayerId = teamPlayerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
