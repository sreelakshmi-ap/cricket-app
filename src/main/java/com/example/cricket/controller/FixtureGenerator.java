   package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.request.AddFixtureRequest;
import com.example.cricket.response.MessageResponse;
import com.example.cricket.service.FixtureGeneratorService;

@RestController
public class FixtureGenerator<T extends Object> {
	@Autowired
	FixtureGeneratorService fixtureGeneratorService;
	
	@PostMapping("/generateFixture")
	public MessageResponse generateFixture(@RequestParam int tournament_id) {
		fixtureGeneratorService.generateFixture(tournament_id);
		return new MessageResponse("Fixture has been generated successfully",HttpStatus.OK);
	
}
	
	@PostMapping("/addFixture")
	public MessageResponse addFixture(@RequestBody AddFixtureRequest matchList,@RequestParam int tournament_id) {
		return fixtureGeneratorService.addFixture(matchList,tournament_id);
	}
}