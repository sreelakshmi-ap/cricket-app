package com.example.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int teamId;
	
	@Column
	String teamName;
	
	@Column
	String city;
	
	@Column
	String teamLogo;
	
	@Column
	int tournamentId;
	
	

	public Team() {
		super();
	}
	
	
	



	public Team(int teamId, String teamName, String city, String teamLogo, int tournamentId) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.city = city;
		this.teamLogo = teamLogo;
		this.tournamentId = tournamentId;
	}






	public Team(String teamName, String city, String teamLogo) {
		super();
		this.teamName = teamName;
		this.city = city;
		this.teamLogo = teamLogo;
	}
	
	






	public Team(int teamId, String teamName, String city, String teamLogo) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.city = city;
		this.teamLogo = teamLogo;
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






	public String getCity() {
		return city;
	}






	public void setCity(String city) {
		this.city = city;
	}






	public String getTeamLogo() {
		return teamLogo;
	}






	public void setTeamLogo(String teamLogo) {
		this.teamLogo = teamLogo;
	}






	public int getTournamentId() {
		return tournamentId;
	}






	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	
	
	
	
	
	

}
