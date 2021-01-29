package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricket.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	Users findByEmail(String email);
	
	boolean existsByEmail(String email);

}
