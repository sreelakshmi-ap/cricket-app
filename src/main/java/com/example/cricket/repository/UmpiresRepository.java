package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Umpires;

public interface UmpiresRepository extends JpaRepository<Umpires,Integer>{

	@Query(value = "SELECT * FROM Cricket.umpires where umpire_id=?1", nativeQuery = true)
	Umpires findUmpiresById(int umpireId);
}
