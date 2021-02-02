package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Tournament;

public interface TournamentRepo extends JpaRepository<Tournament, Integer> {
	@Query(value = "SELECT overs FROM Cricket.tournament where tournament_id=?1", nativeQuery = true)
	int findOversByTournamentId(int tournamentId);
	
	@Query(value = "SELECT * FROM Cricket.tournament where tournament_id=?1", nativeQuery = true)
	Tournament findTournamentId(int tournamentId);

}
