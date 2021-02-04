package com.example.cricket.repository;

import com.example.cricket.model.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore,Integer> {
}
