package com.example.cricket.repository;

import com.example.cricket.response.BatsmanFallOfWicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.FallOfWicket;

import java.util.List;

@Repository
public interface FallOfWicketRepository extends JpaRepository<FallOfWicket, Integer> {

    @Query(value = "select p.player_name as batsmanName,f.team_run as teamRun,f.wicket as wicket,f.wicket_reason as wicketReason,f.overs as overs from Cricket.fall_of_wicket f,Cricket.players p where  p.player_id=f.batsman_id and match_id=?1 and team_id=?2", nativeQuery = true)
    public List<BatsmanFallOfWicket> findAllByMatchIdAndTeamId(int matchId, int teamId);
}
