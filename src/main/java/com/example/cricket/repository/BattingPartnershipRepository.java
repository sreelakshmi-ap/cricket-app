package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.BattingPartnership;

@Repository
public interface BattingPartnershipRepository extends JpaRepository<BattingPartnership, Integer> {

}
