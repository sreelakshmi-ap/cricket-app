package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.LiveUpdate;

@Repository
public interface LiveUpdateRepository  extends JpaRepository<LiveUpdate, Long>{

}
