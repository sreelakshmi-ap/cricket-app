package com.example.cricket.repository;

import com.example.cricket.model.TournamentGround;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TournamentGroundRepository extends JpaRepository<TournamentGround,Integer> {
	@Query(value = "select tournament_ground.ground_id from tournament_ground where tournament_ground.tournament_id=?",nativeQuery = true)
	public List<Integer> getGroundsForMatchs(int tournament_id);

	
}
