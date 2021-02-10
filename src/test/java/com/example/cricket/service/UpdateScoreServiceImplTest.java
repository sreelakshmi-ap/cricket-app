package com.example.cricket.service;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.PlayerScore;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.*;
import com.example.cricket.request.Toss;
import com.example.cricket.response.MainResponse;
import com.sun.corba.se.impl.io.OptionalDataException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UpdateScoreServiceImplTest {

    @Mock
    private TeamScoreRepository teamScoreRepository;

    @Mock
    private MatchRepository matchRepository;

    @Mock
    private TeamPlayerRepository teamPlayerRepository;

    @Mock
    private PlayerScoreRepository playerScoreRepository;


    @InjectMocks
    private UpdateScoreServiceImpl updateScoreService;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void toss() {
        when(teamScoreRepository.findByMatchIdAndTeamId(1,2)).thenReturn(null);
       // when(groundRepository.save(ground)).thenReturn(ground);
        ResponseEntity responseEntity = updateScoreService.toss(new Toss());
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Match ID or Team ID not found", response.getMessage());
    }

    @Test
    void startMatch() {
        Matchs match = new Matchs(1,"",1,1,1,1,"Upcoming",null,null,1,1);
        when(matchRepository.findByMatchId(1)).thenReturn(Optional.of(match));
        when(matchRepository.save(match)).thenReturn(null);
        when(teamScoreRepository.save(new TeamScore())).thenReturn(null);
        when(playerScoreRepository.save(new PlayerScore())).thenReturn(null);
        when(teamPlayerRepository.findByTeamId(2)).thenReturn(null);
        ResponseEntity responseEntity = updateScoreService.startMatch(1);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());
    }

    @Test
    void batsmenList() {
        Matchs match = new Matchs(1,"",1,1,1,1,"Live",null,null,1,1);
        match.setInnings(1);
        when(matchRepository.findByMatchId(1)).thenReturn(Optional.of(match));
        when(playerScoreRepository.findAllBatsmen(1,true)).thenReturn(new ArrayList<>());
        ResponseEntity responseEntity = updateScoreService.batsmenList(1);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());
    }

    @Test
    void bowlerList() {
        Matchs match = new Matchs(1,"",1,1,1,1,"Live",null,null,1,1);
        match.setInnings(1);
        when(matchRepository.findByMatchId(1)).thenReturn(Optional.of(match));
        when(playerScoreRepository.findAllPlayer(1,true)).thenReturn(new ArrayList<>());
        ResponseEntity responseEntity = updateScoreService.bowlerList(1);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());
    }

    @Test
    void currentPlaying() {
    }
}