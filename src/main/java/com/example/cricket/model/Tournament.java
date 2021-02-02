package com.example.cricket.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tournament")
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tournamentId;
	
	@Column
	String tournamentName;
	
	@Column 
	String type;
	
	@Column 
	String tournamentCode;
	
	@Column 
	int overs;
	
	@Column 
	LocalDate startDate;
	
	@Column 
	LocalDate endDate;
	
	@Column 
	LocalTime startOfTime;
	
	@Column 
	LocalTime endOfTime;
	
	@Column 
	String tournamentLogo;
	
	@Column
	String tournamentStatus;

	public Tournament() {
		super();
	}
	
	
	
	




	public Tournament(String tournamentName, String type, String tournamentLogo) {
		super();
		this.tournamentName = tournamentName;
		this.type = type;
		this.tournamentLogo = tournamentLogo;
	}








	public Tournament(String tournamentName, String type, String tournamentCode, String tournamentLogo,
			String tournamentStatus) {
		super();
		this.tournamentName = tournamentName;
		this.type = type;
		this.tournamentCode = tournamentCode;
		this.tournamentLogo = tournamentLogo;
		this.tournamentStatus = tournamentStatus;
	}
	
	
	







	public Tournament(String tournamentName, String type, String tournamentCode, int overs, LocalDate startDate,
			LocalDate endDate, LocalTime startOfTime, LocalTime endOfTime, String tournamentLogo,
			String tournamentStatus) {
		super();
		this.tournamentName = tournamentName;
		this.type = type;
		this.tournamentCode = tournamentCode;
		this.overs = overs;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startOfTime = startOfTime;
		this.endOfTime = endOfTime;
		this.tournamentLogo = tournamentLogo;
		this.tournamentStatus = tournamentStatus;
	}







	public Tournament(int tournamentId, String tournamentName, String type, String tournamentCode, int overs,
			LocalDate startDate, LocalDate endDate, LocalTime startOfTime, LocalTime endOfTime, String tournamentLogo,
			String tournamentStatus) {
		super();
		this.tournamentId = tournamentId;
		this.tournamentName = tournamentName;
		this.type = type;
		this.tournamentCode = tournamentCode;
		this.overs = overs;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startOfTime = startOfTime;
		this.endOfTime = endOfTime;
		this.tournamentLogo = tournamentLogo;
		this.tournamentStatus = tournamentStatus;
	}







	public int getTournamentId() {
		return tournamentId;
	}



	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}



	public String getTournamentName() {
		return tournamentName;
	}



	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getTournamentCode() {
		return tournamentCode;
	}



	public void setTournamentCode(String tournamentCode) {
		this.tournamentCode = tournamentCode;
	}



	public int getOvers() {
		return overs;
	}



	public void setOvers(int overs) {
		this.overs = overs;
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



	public String getTournamentLogo() {
		return tournamentLogo;
	}



	public void setTournamentLogo(String tournamentLogo) {
		this.tournamentLogo = tournamentLogo;
	}






	public String getTournamentStatus() {
		return tournamentStatus;
	}






	public void setTournamentStatus(String tournamentStatus) {
		this.tournamentStatus = tournamentStatus;
	}
	
	
	
	 
	
	
	

}
