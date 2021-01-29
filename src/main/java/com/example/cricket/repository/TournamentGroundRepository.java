package com.example.cricket.repository;

import com.example.cricket.model.TournamentGround;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentGroundRepository extends JpaRepository<TournamentGround,Integer> {
}
