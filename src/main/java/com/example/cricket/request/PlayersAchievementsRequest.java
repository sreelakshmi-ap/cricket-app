package com.example.cricket.request;

import java.util.List;

import com.example.cricket.model.PlayersAchievements;

public class PlayersAchievementsRequest {
	List<PlayersAchievements> request;
	
	

	public PlayersAchievementsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayersAchievementsRequest(List<PlayersAchievements> request) {
		super();
		this.request = request;
	}

	public List<PlayersAchievements> getRequest() {
		return request;
	}

	public void setRequest(List<PlayersAchievements> request) {
		this.request = request;
	}

	
	
	
	

}
