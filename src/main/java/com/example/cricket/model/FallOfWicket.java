package com.example.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fall_of_wicket")
public class FallOfWicket {

	@Id
	@Column(name = "fow_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int FOWid;
	@Column
	int batsmanId;
	@Column
	int bowlerId;
	@Column
	int fielderId;
	@Column
	int teamRun;
	@Column
	int wicket;
	@Column
	int matchId;
	@Column
	int teamId;
	@Column
	String wicketReason;
	@Column
	float overs;

	public FallOfWicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FallOfWicket(int fOWid, int batsmanId, int bowlerId, int fielderId, int teamRun, int wicket, int matchId,
			int teamId, String wicketReason, float overs) {
		super();
		FOWid = fOWid;
		this.batsmanId = batsmanId;
		this.bowlerId = bowlerId;
		this.fielderId = fielderId;
		this.teamRun = teamRun;
		this.wicket = wicket;
		this.matchId = matchId;
		this.teamId = teamId;
		this.wicketReason = wicketReason;
		this.overs = overs;
	}

	public float getOvers() {
		return overs;
	}

	public void setOvers(float overs) {
		this.overs = overs;
	}

	public int getFOWid() {
		return FOWid;
	}

	public void setFOWid(int fOWid) {
		FOWid = fOWid;
	}

	public int getBatsmanId() {
		return batsmanId;
	}

	public void setBatsmanId(int batsmanId) {
		this.batsmanId = batsmanId;
	}

	public int getBowlerId() {
		return bowlerId;
	}

	public void setBowlerId(int bowlerId) {
		this.bowlerId = bowlerId;
	}

	public int getFielderId() {
		return fielderId;
	}

	public void setFielderId(int fielderId) {
		this.fielderId = fielderId;
	}

	public int getTeamRun() {
		return teamRun;
	}

	public void setTeamRun(int teamRun) {
		this.teamRun = teamRun;
	}

	public int getWicket() {
		return wicket;
	}

	public void setWicket(int wicket) {
		this.wicket = wicket;
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

	public String getWicketReason() {
		return wicketReason;
	}

	public void setWicketReason(String wicketReason) {
		this.wicketReason = wicketReason;
	}

}
