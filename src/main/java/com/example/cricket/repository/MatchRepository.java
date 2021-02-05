package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.Tournament;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Matchs,Integer>{

    @Query(value = "SELECT * FROM matchs where match_id=?1", nativeQuery = true)
    public Optional<Matchs> findByMatchId(int matchId);
    
	@Query(value = "SELECT * FROM Cricket.matchs where tournament_id=?1", nativeQuery = true)
	List<Matchs> findTournamentsId(int tournamentId);
}
