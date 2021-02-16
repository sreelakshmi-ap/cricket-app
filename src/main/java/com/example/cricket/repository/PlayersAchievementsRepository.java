package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.PlayersAchievements;
import com.example.cricket.response.AchievementResponse;

public interface PlayersAchievementsRepository extends JpaRepository<PlayersAchievements,Integer>{
	
	@Query(value = "SELECT achievement_name as achievementname,match_id as matchid FROM Cricket.players_achievements where player_id=?1 and tournament_id=?2",nativeQuery = true)
	List<AchievementResponse> GetAchievement(int playerId,int tournamentId);

}
