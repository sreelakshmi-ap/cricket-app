package com.example.cricket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PlayersAchievements")
public class PlayersAchievements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int achievement_id;
	
	int match_id;
	int player_id;
	int tournament_id;
    String achievement_name;
    
	public PlayersAchievements(int achievement_id, int match_id, int player_id, int tournament_id,
			String achievement_name) {
		super();
		this.achievement_id = achievement_id;
		this.match_id = match_id;
		this.player_id = player_id;
		this.tournament_id = tournament_id;
		this.achievement_name = achievement_name;
	}

	public PlayersAchievements() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public int getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(int tournament_id) {
		this.tournament_id = tournament_id;
	}

	public String getAchievement_name() {
		return achievement_name;
	}

	public void setAchievement_name(String achievement_name) {
		this.achievement_name = achievement_name;
	}
    
    

}
