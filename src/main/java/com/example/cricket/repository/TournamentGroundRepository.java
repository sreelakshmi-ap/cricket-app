package com.example.cricket.repository;

import com.example.cricket.model.TournamentGround;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.cricket.model.TournamentGround;

import java.util.List;
import java.util.Optional;



public interface TournamentGroundRepository extends JpaRepository<TournamentGround,Integer> {
   public Optional<TournamentGround> findByGroundIdAndTournamentId(Integer groundId, int tournamentId);

  public List<TournamentGround> findAllByTournamentId(int tournamentId);
	@Query(value = "SELECT ground_id FROM Cricket.tournament_ground where tournament_id=?1", nativeQuery = true)
	List<Integer> findGroundsByTournamentId(int tournamentId);
  
  	@Query(value = "select tournament_ground.ground_id from tournament_ground where tournament_ground.tournament_id=?",nativeQuery = true)
	public List<Integer> getGroundsForMatchs(int tournament_id);

}
