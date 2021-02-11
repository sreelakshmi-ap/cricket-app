package com.example.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket.model.FallOfWicket;
import com.example.cricket.model.LiveUpdate;
import com.example.cricket.repository.FallOfWicketRepository;
import com.example.cricket.request.LiveUpdateRequest;

@Service
public class FallOfWicketService {
	@Autowired
	FallOfWicketRepository fallOfWicketRepository;

	public void setRunsAndWickets(LiveUpdateRequest livereq, int runs, int wickets, float over) {
		LiveUpdate liveUpdate = livereq.getLiveUpdate();
		FallOfWicket fallOfWicket = new FallOfWicket();
		fallOfWicket.setBatsmanId(livereq.getWicketId());
		fallOfWicket.setBowlerId(liveUpdate.getBowler_id());
		fallOfWicket.setFielderId(liveUpdate.getFielder_id());
		fallOfWicket.setMatchId(liveUpdate.getMatch_id());
		fallOfWicket.setTeamId(liveUpdate.getTeam_id());
		fallOfWicket.setWicket(wickets);
		fallOfWicket.setWicketReason(liveUpdate.getWicket_reason());
		fallOfWicket.setTeamRun(runs);
		fallOfWicket.setOvers(over);
		fallOfWicketRepository.save(fallOfWicket);
	}
}
