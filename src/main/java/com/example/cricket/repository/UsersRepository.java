package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	Users findByEmail(String email);
	
	boolean existsByEmail(String email);
	@Query(value = "SELECT * FROM users WHERE user_id = ?1", nativeQuery = true)
	Users findByUserID(long userId);
}
