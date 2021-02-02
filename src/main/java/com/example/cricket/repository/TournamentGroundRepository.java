package com.example.cricket.repository;

import com.example.cricket.model.TournamentGround;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TournamentGroundRepository extends JpaRepository<TournamentGround,Integer> {
   public Optional<TournamentGround> findByGroundIdAndTournamentId(Integer groundId, int tournamentId);

  public List<TournamentGround> findAllByTournamentId(int tournamentId);
}
