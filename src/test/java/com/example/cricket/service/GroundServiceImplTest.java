package com.example.cricket.service;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.TournamentGround;
import com.example.cricket.repository.GroundRepository;
import com.example.cricket.repository.TournamentGroundRepository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Optional;

import com.example.cricket.response.MainResponse;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class GroundServiceImplTest {

    @Mock
    private GroundRepository groundRepository;

    @Mock
    private TournamentGroundRepository tournamentGroundRepository;

    @InjectMocks
    private GroundServiceImpl groundService;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addGround() {
        GroundEntity ground = new GroundEntity();
        ground.setName("GroundOne");
        ground.setCity("city");
        ground.setLatitude("40");
        ground.setLongitude("43");
        when(groundRepository.findAll()).thenReturn(new ArrayList<>());
        when(groundRepository.save(ground)).thenReturn(ground);
        ResponseEntity responseEntity = groundService.addGround(ground);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());

    }

    @Test
    void getAllGround() {
        when(groundRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity responseEntity = groundService.getAllGround();
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());
    }

    @Test
    void tournamentGround() {
        TournamentGround map = new TournamentGround();
        map.setGroundId(1);
        GroundEntity ground = new GroundEntity();
        ground.setName("GroundOne");
        ground.setCity("city");
        ground.setLatitude("40");
        ground.setLongitude("43");
        when(groundRepository.findById(map.getGroundId())).thenReturn(Optional.of(ground));
        when(tournamentGroundRepository.save(map)).thenReturn(map);
        ResponseEntity responseEntity = groundService.tournamentGround(map);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());


    }
}