package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {
	@Query(value = "select teams.team_id from teams where tournament_id=?",nativeQuery = true)
	public List<Integer> getTeams(int tournament_id);


	

}
