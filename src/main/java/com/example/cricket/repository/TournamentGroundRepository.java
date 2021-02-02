package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.TournamentGround;

public interface TournamentGroundRepository extends JpaRepository<TournamentGround,Integer> {
	@Query(value = "SELECT ground_id FROM Cricket.tournament_ground where tournament_id=?1", nativeQuery = true)
	List<Integer> findGroundsByTournamentId(int tournamentId);
}
