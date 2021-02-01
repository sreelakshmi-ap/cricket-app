package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricket.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {

}
