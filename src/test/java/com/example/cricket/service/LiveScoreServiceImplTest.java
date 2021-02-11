package com.example.cricket.service;

import com.example.cricket.model.Matchs;
import com.example.cricket.model.PlayerScore;
import com.example.cricket.model.TeamScore;
import com.example.cricket.repository.MatchRepository;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamPlayerRepository;
import com.example.cricket.repository.TeamScoreRepository;
import com.example.cricket.response.MainResponse;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class LiveScoreServiceImplTest {


    @Mock
    private TeamScoreRepository teamScoreRepository;

    @Mock
    private MatchRepository matchRepository;

    @Mock
    private PlayerScoreRepository playerScoreRepository;


    @InjectMocks
    private LiveScoreServiceImpl liveScoreService;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }


    @Test
    void getLiveScore() {
        Matchs matchs = new Matchs(1, "", 1, 1, 1, 1, "Live", null, null, 1, 1);
        matchs.setInnings(1);
        TeamScore teamScore = new TeamScore();
        teamScore.setBattingOrder(true);
        when(matchRepository.findByMatchId(1)).thenReturn(Optional.of(matchs));
        when(teamScoreRepository.findByMatchIdAndTeamId(1,1)).thenReturn(teamScore);
        when(playerScoreRepository.findPlayingBatsmen(1,1)).thenReturn(new ArrayList<>());
        ResponseEntity responseEntity = liveScoreService.getLiveScore(1);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());
    }
}