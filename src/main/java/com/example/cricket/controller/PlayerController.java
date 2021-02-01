package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.PlayerEntity;
import com.example.cricket.model.TeamPlayerEntity;
import com.example.cricket.service.PlayerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService  playerService;
	
	@GetMapping("/playersList")
	public ResponseEntity<?> playersList() {
		return playerService.playersList() ;		
	}
	
	@PutMapping("/addNewPlayer")
	public ResponseEntity<?> newPlayer(@RequestParam("teamId") int teamId, @RequestParam("designation") String designation, @RequestParam("player") String player) throws JsonMappingException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		PlayerEntity playerEntity = mapper.readValue(player, PlayerEntity.class);
		return playerService.addNewPlayer(playerEntity, teamId, designation);
	}
	
	@PutMapping("/addExistingPlayer")
	public ResponseEntity<?> existingPlayer(@RequestBody TeamPlayerEntity teamPlayerEntity){
		return playerService.addExistingPlayer(teamPlayerEntity);
		
	}
}
