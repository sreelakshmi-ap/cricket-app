package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.response.OverviewResponse;
import com.example.cricket.service.createTournamentService;


@RestController
@RequestMapping("/test")
public class OverviewController {
	@Autowired
	createTournamentService service;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/Overview")
	public OverviewResponse getOverview(@RequestParam int tournamentId) {
		return service.getOverview(tournamentId);
//		return new OverviewResponse(teams, Overs, grounds, umpires, startDate, endDate, startOfTime, endOfTime);

	}
}
