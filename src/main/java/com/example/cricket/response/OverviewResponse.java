package com.example.cricket.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.Team;
import com.example.cricket.model.Umpires;

public class OverviewResponse {
	private List<Team> teams;
	private int Overs;
	private List<GroundEntity> grounds;
	private List<Umpires> umpireList;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalTime startOfTime;
	private LocalTime endOfTime;

	public OverviewResponse(List<Team> teams, int overs, List<GroundEntity> grounds, List<Umpires> umpireList,
			LocalDate startDate, LocalDate endDate, LocalTime startOfTime, LocalTime endOfTime) {
		super();
		this.teams = teams;
		Overs = overs;
		this.grounds = grounds;
		this.umpireList = umpireList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startOfTime = startOfTime;
		this.endOfTime = endOfTime;
	}

	public OverviewResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public int getOvers() {
		return Overs;
	}

	public void setOvers(int overs) {
		Overs = overs;
	}

	public List<GroundEntity> getGrounds() {
		return grounds;
	}

	public void setGrounds(List<GroundEntity> grounds) {
		this.grounds = grounds;
	}

	public List<Umpires> getUmpireList() {
		return umpireList;
	}

	public void setUmpireList(List<Umpires> umpireList) {
		this.umpireList = umpireList;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalTime getStartOfTime() {
		return startOfTime;
	}

	public void setStartOfTime(LocalTime startOfTime) {
		this.startOfTime = startOfTime;
	}

	public LocalTime getEndOfTime() {
		return endOfTime;
	}

	public void setEndOfTime(LocalTime endOfTime) {
		this.endOfTime = endOfTime;
	}

}