package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.Matchs;

@Repository
public interface MatchRepository extends JpaRepository<Matchs,Integer>{

}
