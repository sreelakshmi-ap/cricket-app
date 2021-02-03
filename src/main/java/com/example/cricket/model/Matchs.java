package com.example.cricket.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Matchs")
public class Matchs{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int match_id;
	
	String match_name;
	int team_1_id;
	int team_2_id;
	int tournamentId;
	int ground_id;
	String status;
	LocalDate match_date;
	String stopped_reason;
	int umpire_1_id;
	int umpire_2_id;
	int innings;
	LocalTime start_time;
	LocalTime end_time;

	public Matchs(int match_id, String match_name, int team_1_id,int team_2_id, int tournamentId,
			int ground_id,String status,LocalDate match_date,String stopped_reason,int umpire_1_id,
			int umpire_2_id) {
		super();
		this.match_id = match_id;
		this.match_name = match_name;
		this.team_1_id = team_1_id;
		this.team_2_id=team_2_id;
		this.tournamentId = tournamentId;
		this.ground_id=ground_id;
		this.status=status;
		this.match_date=match_date;
		this.stopped_reason=stopped_reason;
		this.umpire_1_id=umpire_1_id;
		this.umpire_2_id=umpire_2_id;
		
		
	}
	public Matchs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public String getMatch_name() {
		return match_name;
	}
	public void setMatch_name(String match_name) {
		this.match_name = match_name;
	}
	
	public int getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
		public int getTeam_1_id() {
		return team_1_id;
	}
	public void setTeam_1_id(int team_1_id) {
		this.team_1_id = team_1_id;
	}
	public int getTeam_2_id() {
		return team_2_id;
	}
	public void setTeam_2_id(int team_2_id) {
		this.team_2_id = team_2_id;
	}
	public int getGround_id() {
		return ground_id;
	}
	public void setGround_id(int ground_id) {
		this.ground_id = ground_id;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getMatch_date() {
		return match_date;
	}
	public void setMatch_date(LocalDate match_date) {
		this.match_date = match_date;
	}
	public String getStopped_reason() {
		return stopped_reason;
	}
	public void setStopped_reason(String stopped_reason) {
		this.stopped_reason = stopped_reason;
	}
	public int getUmpire_1_id() {
		return umpire_1_id;
	}
	public void setUmpire_1_id(int umpire_1_id) {
		this.umpire_1_id = umpire_1_id;
	}
	public int getUmpire_2_id() {
		return umpire_2_id;
	}
	public void setUmpire_2_id(int umpire_2_id) {
		this.umpire_2_id = umpire_2_id;
	}

	public String getStatus() {
		return status;
	}

	public int getInnings() {
		return innings;
	}

	public void setInnings(int innings) {
		this.innings = innings;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}

	public LocalTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}
}