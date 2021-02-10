package com.example.cricket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket.model.Umpires;

import com.example.cricket.repository.UmpiresRepository;
import com.example.cricket.response.UmpireDetailResponse;
import com.example.cricket.response.UmpireMatchResponse;

@Service
public class UmpireDetailService {


	@Autowired
	UmpiresRepository umpireRepo;

	public UmpireMatchResponse umpireDetails(int umpireId, int tournamentId) {
		Optional<Umpires> value = umpireRepo.findById(umpireId);
		Umpires umpire = value.get();
		List<UmpireDetailResponse> matchValues = umpireRepo.findUmpiresDetails(umpireId, tournamentId);
		UmpireMatchResponse response = new UmpireMatchResponse(umpire, matchValues);
		return response;
	}

}
