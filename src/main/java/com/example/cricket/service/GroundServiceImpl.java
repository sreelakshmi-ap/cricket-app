package com.example.cricket.service;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.TournamentGround;
import com.example.cricket.response.MainResponse;
import com.example.cricket.repository.GroundRepository;
import com.example.cricket.repository.TournamentGroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GroundServiceImpl implements  GroundService {

    @Autowired
    private GroundRepository groundRepository;

    @Autowired
    private TournamentGroundRepository tournamentGroundRepository;

    @Override
    public ResponseEntity<?> addGround(GroundEntity add) {
        List<GroundEntity> grounds = groundRepository.findAll();
        if(!grounds.isEmpty()){
            for(GroundEntity ground :grounds){
                if (ground.getLatitude().equals(add.getLatitude()) && ground.getLongitude().equals(add.getLongitude())){
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(new MainResponse(409,"Stadium already exists with a name of "+ground.getName(),""));
                }
            }
        }
        groundRepository.save(add);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MainResponse(201,"Success",""));
    }

    @Override
    public ResponseEntity<?> getAllGround() {
        List<GroundEntity> grounds = groundRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200,"Success",grounds));
    }

    @Override
    public ResponseEntity<?> tournamentGround(TournamentGround map) {
        Optional<GroundEntity> ground = groundRepository.findById(map.getGroundId());
        if(ground.isPresent()){
            tournamentGroundRepository.save(map);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MainResponse(201,"Success",""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(404,"Ground ID not found",""));

    }


    

    


}
