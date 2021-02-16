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
	
	@Column
    Integer wins;
	
	@Column
    Integer losses;
	
	@Column
    Integer points;
	
	@Column
	Integer draw_or_cancelled;
	

	@Column
	Double net_run_rate;
	
	

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






	public Team(int teamId, String teamName, String city, String teamLogo, int tournamentId, Integer wins, Integer losses,

			Integer points, Integer draw_or_cancelled,Double net_run_rate) {
			

		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.city = city;
		this.teamLogo = teamLogo;
		this.tournamentId = tournamentId;
		this.wins = wins;
		this.losses = losses;
		this.points = points;
		this.draw_or_cancelled = draw_or_cancelled;

		this.net_run_rate=net_run_rate;

	}
	
	

	





	public Team(int teamId, int losses) {
		super();
		this.teamId = teamId;
		this.losses = losses;
	}






	public Team(int teamId, int wins, int points) {
		super();
		this.teamId = teamId;
		this.wins = wins;
		this.points = points;
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






	public Integer getWins() {
		return wins;
	}






	public void setWins(Integer wins) {
		this.wins = wins;
	}






	public Integer getLosses() {
		return losses;
	}






	public void setLosses(Integer losses) {
		this.losses = losses;
	}






	public Integer getPoints() {
		return points;
	}






	public void setPoints(Integer points) {
		this.points = points;
	}






	public Integer getDraw_or_cancelled() {
		return draw_or_cancelled;
	}






	public void setDraw_or_cancelled(Integer draw_or_cancelled) {
		this.draw_or_cancelled = draw_or_cancelled;
	}







	public Double getNet_run_rate() {
		return net_run_rate;
	}






	public void setNet_run_rate(Double net_run_rate) {
		this.net_run_rate = net_run_rate;
	}


    




	
}
