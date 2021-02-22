package com.example.cricket.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.cricket.response.UmpireMatchResponse;
import com.example.cricket.service.UmpireDetailService;

@RestController
public class UmpireController {
	@Autowired
	UmpireDetailService umpireDetailsService;

	@GetMapping("/umpireDetails")
	UmpireMatchResponse  umpireDetails(@RequestParam int umpireId, @RequestParam int tournamentId) {
		return umpireDetailsService.umpireDetails(umpireId, tournamentId);
	}

}
