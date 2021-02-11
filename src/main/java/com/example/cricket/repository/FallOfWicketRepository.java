package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.FallOfWicket;

@Repository
public interface FallOfWicketRepository extends JpaRepository<FallOfWicket, Integer> {

}
