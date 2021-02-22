package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.TournamentGround;
import com.example.cricket.response.GroundResponse;
import com.example.cricket.service.GroundService;

@RestController
public class GroundController {

    @Autowired
    private GroundService groundService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/groundDetails")
    public GroundResponse groundDetails(@RequestParam int groundId,@RequestParam int tournamentId){
    	return groundService.groundDetails(groundId, tournamentId);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addGround")
    public ResponseEntity<?> addGround(@RequestBody GroundEntity add){
       return groundService.addGround(add);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllGround")
    public ResponseEntity<?> getAllGround(){
        return groundService.getAllGround();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tournamentGround")
    public ResponseEntity<?> tournamentGround(@RequestBody TournamentGround map){
        return groundService.tournamentGround(map);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteGround")
    public ResponseEntity<?> deleteGround(@RequestBody TournamentGround del){
        return groundService.deleteGround(del);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getTournamentGround/{tournamentId}")
    public ResponseEntity<?> getTournamentGround(@PathVariable int tournamentId){
        return  groundService.getTournamentGround(tournamentId);

    }

}
