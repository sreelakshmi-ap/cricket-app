package com.example.cricket.repository;

import com.example.cricket.model.GroundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroundRepository extends JpaRepository<GroundEntity,Integer> {
}
