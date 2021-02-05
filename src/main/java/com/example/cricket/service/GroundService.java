package com.example.cricket.service;

import org.springframework.http.ResponseEntity;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.TournamentGround;
import com.example.cricket.response.GroundResponse;

public interface GroundService {
	public GroundResponse groundDetails(int groundId, int tournamentId);

	public ResponseEntity<?> addGround(GroundEntity add);

	public ResponseEntity<?> getAllGround();

	public ResponseEntity<?> tournamentGround(TournamentGround map);

	public ResponseEntity<?> deleteGround(TournamentGround del);


	public ResponseEntity<?> getTournamentGround(int tournamentId);

    public ResponseEntity<?> tournamentGround(TournamentGround map);

    public ResponseEntity<?> deleteGround(TournamentGround del);

   public ResponseEntity<?> getTournamentGround(int tournamentId);
}
