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

    Integer runs;
    
    @Column
    Integer hundreds;
    
    @Column
    Integer fifties;
    
    @Column
    Integer fours;
    
    @Column
    Integer sixes;
    
    @Column
    Integer wickets;
    
    @Column
    Integer five_wickets_hauls;
    
    
   
	
	public TeamPlayerEntity(int teamPlayerId, int teamId, int playerId, String designation, Integer runs,
			Integer hundreds, Integer fifties, Integer fours, Integer sixes, Integer wickets,
			Integer five_wickets_hauls) {
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

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	public Integer getHundreds() {
		return hundreds;
	}

	public void setHundreds(Integer hundreds) {
		this.hundreds = hundreds;
	}

	public Integer getFifties() {
		return fifties;
	}

	public void setFifties(Integer fifties) {
		this.fifties = fifties;
	}

	public Integer getFours() {
		return fours;
	}

	public void setFours(Integer fours) {
		this.fours = fours;
	}

	public Integer getSixes() {
		return sixes;
	}

	public void setSixes(Integer sixes) {
		this.sixes = sixes;
	}

	public Integer getWickets() {
		return wickets;
	}

	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}

	public Integer getFive_wickets_hauls() {
		return five_wickets_hauls;
	}

	public void setFive_wickets_hauls(Integer five_wickets_hauls) {
		this.five_wickets_hauls = five_wickets_hauls;
	}
    
    


}
