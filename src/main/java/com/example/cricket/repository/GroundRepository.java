package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.response.GroundViewResponse;

public interface GroundRepository extends JpaRepository<GroundEntity, Integer> {
	@Query(value = "SELECT * FROM Cricket.ground where ground_id=?1", nativeQuery = true)
	GroundEntity findGroundById(int tournamentId);
//	
//	@Query(value = "select matchs.ground_id as groundId,ground.name as name,ground.city as city,ground.latitude as latitude,ground.longitude as longitude,ground.image_path as imagePath,matchs.match_name as matchName FROM matchs,ground where ground.ground_id=?1 and matchs.tournament_id=?2 and matchs.ground_id=ground.ground_id;", nativeQuery = true)
//	List<GroundViewResponse> getGrounddetails(int groundId,int tournamentId);

	@Query(value = "select matchs.match_name as matchName FROM matchs,ground where ground.ground_id=?1 and matchs.tournament_id=?2 and matchs.ground_id=ground.ground_id;", nativeQuery = true)
	List<GroundViewResponse> getGrounddetails(int groundId, int tournamentId);

}
