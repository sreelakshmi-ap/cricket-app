package com.example.cricket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.cricket.model.Tournament;
import com.example.cricket.model.Umpires;
import com.example.cricket.repository.UmpiresRepository;
import com.example.cricket.response.ListAndMessageResponse;
import com.example.cricket.response.MessageResponse;
import com.example.cricket.response.UmpireResponse;
import com.example.cricket.service.createTournamentService;

@RestController
@RequestMapping("/createTournament")
public class CreateTournament {
	
   @Autowired
   UmpiresRepository umpireRepository;
   
   @Autowired
   createTournamentService tournamentService;
   
   @Autowired
   Tournament tournament;

	
   @PostMapping("/addUmpire")
   public MessageResponse addUmpire(@RequestBody Umpires umpire) {
	   umpireRepository.save(umpire);
	   return new MessageResponse("umpire added successfully",HttpStatus.OK);
   }
   
   @GetMapping("/getAllUmpires")
   public List<Umpires> getAllUmpires(){
	   return umpireRepository.findAll();
	   
   }
    
   
   @GetMapping("/getUmpireById")
   public Optional<Umpires> getUmpireById(@RequestParam int umpire_id) {
	   return umpireRepository.findById(umpire_id);
	   
   }
   
   @PostMapping("/addUmpireToTournament")
   public MessageResponse addUmpireToTournament(@RequestParam int umpire_id,int tournament_id) {
	   return tournamentService.addUmpireToTournament(umpire_id, tournament_id);
	   
   }
   
   @GetMapping("/getAllUmpiresForTournament")
   public ListAndMessageResponse getAllUmpiresForTournament(@RequestParam int tournament_id){
	    
	List<UmpireResponse> umpireList = tournamentService.getAllUmpiresOfTournament(tournament_id);
   
	return new ListAndMessageResponse(umpireList, HttpStatus.OK, umpireList.size());
  }
   
   @DeleteMapping("/deleteUmpireById")
	   public MessageResponse deleteUmpireById(@RequestParam int umpire_id) {
		   umpireRepository.deleteById(umpire_id);
		   return new MessageResponse("umpire deleted successfully",HttpStatus.OK);
		   
	   }
   
  
   
   }
   
 

 

