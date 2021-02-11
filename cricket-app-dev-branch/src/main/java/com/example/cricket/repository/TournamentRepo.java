package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricket.model.Tournament;

public interface TournamentRepo extends JpaRepository<Tournament, Integer> {

}
