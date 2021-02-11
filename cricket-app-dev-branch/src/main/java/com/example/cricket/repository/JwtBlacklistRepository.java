package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.JwtBlacklist;


@Repository
public interface JwtBlacklistRepository extends JpaRepository<JwtBlacklist, Integer>{

	JwtBlacklist findByTokenEquals(String token);
	

}