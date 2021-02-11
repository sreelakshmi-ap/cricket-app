package com.example.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batting_partnership")
public class BattingPartnership {
	@Id
	@Column(name = "parnership_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int parnershipId;
	@Column
	int matchId;
	@Column
	int teamId;
	@Column
	int batmanOneId;
	@Column
	int batmanTwoId;
	@Column
	int runs;
	@Column
	int balls;
	@Column
	boolean status;

	public BattingPartnership() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BattingPartnership(int parnershipId, int matchId, int teamId, int batmanOneId, int batmanTwoId, int runs,
			int balls, boolean status) {
		super();
		this.parnershipId = parnershipId;
		this.matchId = matchId;
		this.teamId = teamId;
		this.batmanOneId = batmanOneId;
		this.batmanTwoId = batmanTwoId;
		this.runs = runs;
		this.balls = balls;
		this.status = status;
	}
	
	

	public BattingPartnership(int matchId, int teamId, int batmanOneId, int batmanTwoId, int runs, int balls,
			boolean status) {
		super();
		this.matchId = matchId;
		this.teamId = teamId;
		this.batmanOneId = batmanOneId;
		this.batmanTwoId = batmanTwoId;
		this.runs = runs;
		this.balls = balls;
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getBatmanOneId() {
		return batmanOneId;
	}

	public void setBatmanOneId(int batmanOneId) {
		this.batmanOneId = batmanOneId;
	}

	public int getBatmanTwoId() {
		return batmanTwoId;
	}

	public void setBatmanTwoId(int batmanTwoId) {
		this.batmanTwoId = batmanTwoId;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}
}
