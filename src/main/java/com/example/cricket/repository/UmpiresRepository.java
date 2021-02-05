package com.example.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.Umpires;
import com.example.cricket.response.UmpireDetailResponse;

public interface UmpiresRepository extends JpaRepository<Umpires, Integer> {

	@Query(value = "SELECT * FROM Cricket.umpires where umpire_id=?1", nativeQuery = true)
	Umpires findUmpiresById(int umpireId);

	@Query(value = "select matchs.match_name as matchName\r\n" + "FROM matchs,umpires\r\n"
			+ "where umpires.umpire_id=?1 and matchs.tournament_id=?2 and (matchs.umpire_1_id=umpires.umpire_id or matchs.umpire_2_id=umpires.umpire_id);", nativeQuery = true)
	List<UmpireDetailResponse> findUmpiresDetails(int umpireId, int tournamentId);

}
