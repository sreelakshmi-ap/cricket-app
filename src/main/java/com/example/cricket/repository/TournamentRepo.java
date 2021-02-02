package com.example.cricket.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Tournament;

public interface TournamentRepo extends JpaRepository<Tournament, Integer> {
	@Query(value = "select tournament.start_date from tournament where tournament.tournament_id=?",nativeQuery = true)
	public LocalDate getStartDate(int tournament_id);
	
	@Query(value = "select tournament.end_date from tournament where tournament.tournament_id=?",nativeQuery = true)
	public LocalDate getEndDate(int tournament_id);

}
