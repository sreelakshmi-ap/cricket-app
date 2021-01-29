package com.example.cricket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tournament_umpire_mapping")
public class Tournament_umpire_mapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int map_id;
	
	int tournament_id;
	int umpire_id;
	
	public Tournament_umpire_mapping(int map_id, int tournament_id, int umpire_id) {
		super();
		this.map_id = map_id;
		this.tournament_id = tournament_id;
		this.umpire_id = umpire_id;
	}
	
	public Tournament_umpire_mapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMap_id() {
		return map_id;
	}

	public void setMap_id(int map_id) {
		this.map_id = map_id;
	}

	public int getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(int tournament_id) {
		this.tournament_id = tournament_id;
	}

	public int getUmpire_id() {
		return umpire_id;
	}

	public void setUmpire_id(int umpire_id) {
		this.umpire_id = umpire_id;
	}
	
	

}
