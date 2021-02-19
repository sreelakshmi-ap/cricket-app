package com.example.cricket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.BattingPartnership;

@Repository
public interface BattingPartnershipRepository extends JpaRepository<BattingPartnership, Integer> {
	
	
	@Query(value = "SELECT * FROM Cricket.batting_partnership where status=1 and match_id=?1 and team_id=?2",nativeQuery = true)
	public BattingPartnership Partnership(int matchId,int teamId);
	
	@Query(value = "SELECT * FROM Cricket.batting_partnership where ((batman_one_id=?1 and batman_two_id=?2)or(batman_one_id=?2 and batman_two_id=?1)) and match_id=?3",nativeQuery = true)
	Optional<BattingPartnership> PartnershipExist(int batsmanOneId,int batsmanTwoId,int matchId);

	public List<?> findAllByMatchIdAndTeamId(int matchId, int teamId);
}
