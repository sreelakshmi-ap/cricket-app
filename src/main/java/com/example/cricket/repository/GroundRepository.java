package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.GroundEntity;

public interface GroundRepository extends JpaRepository<GroundEntity, Integer> {
	@Query(value = "SELECT * FROM Cricket.ground where ground_id=?1", nativeQuery = true)
	GroundEntity findGroundById(int tournamentId);
}
