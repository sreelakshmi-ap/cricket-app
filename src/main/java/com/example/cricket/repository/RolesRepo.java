package com.example.cricket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricket.model.ERoles;
import com.example.cricket.model.Role;

public interface RolesRepo extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERoles name);

}
