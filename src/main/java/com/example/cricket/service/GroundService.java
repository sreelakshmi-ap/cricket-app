package com.example.cricket.service;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.TournamentGround;
import org.springframework.http.ResponseEntity;

public interface GroundService {
    public ResponseEntity<?> addGround(GroundEntity add);

    public ResponseEntity<?> getAllGround();

    public ResponseEntity<?> tournamentGround(TournamentGround map);

    public ResponseEntity<?> deleteGround(TournamentGround del);

   public ResponseEntity<?> getTournamentGround(int tournamentId);
}
