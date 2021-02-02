package com.example.cricket.controller;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.TournamentGround;
import com.example.cricket.service.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroundController {

    @Autowired
    private GroundService groundService;

    @PostMapping("/addGround")
    public ResponseEntity<?> addGround(@RequestBody GroundEntity add){
       return groundService.addGround(add);
    }

    @GetMapping("/getAllGround")
    public ResponseEntity<?> getAllGround(){
        return groundService.getAllGround();
    }

    @PutMapping("/tournamentGround")
    public ResponseEntity<?> tournamentGround(@RequestBody TournamentGround map){
        return groundService.tournamentGround(map);
    }

    @DeleteMapping("/deleteGround")
    public ResponseEntity<?> deleteGround(@RequestBody TournamentGround del){
        return groundService.deleteGround(del);
    }

    @GetMapping("/getTournamentGround/{tournamentId}")
    public ResponseEntity<?> getTournamentGround(@PathVariable int tournamentId){
        return  groundService.getTournamentGround(tournamentId);

    }

}
