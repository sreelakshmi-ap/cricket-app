package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Tournament_umpire_mapping;


public interface Tournament_umpire_mapping_Repository extends JpaRepository<Tournament_umpire_mapping,Integer>{
	@Query(value = "select umpires.umpire_name,umpires.image_path from umpires where umpires.umpire_id in(select umpire_id from tournament_umpire_mapping where tournament_id=?)",nativeQuery = true)
	public List<String> getAllUmpiresOfTournament(int tournament_id);

	@Query(value = "select tournament_umpire_mapping.umpire_id from tournament_umpire_mapping where tournament_umpire_mapping.tournament_id=?",nativeQuery = true)
	public List<Integer> getAllUmpiresforMatch(int tournament_id);
}
