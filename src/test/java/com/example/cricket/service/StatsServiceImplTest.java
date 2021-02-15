package com.example.cricket.service;

import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.response.BestBattingStrikeRate;
import com.example.cricket.response.BestEconomy;
import com.example.cricket.response.HighestScore;
import com.example.cricket.response.MainResponse;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class StatsServiceImplTest {

    @Mock
    private PlayerScoreRepository playerScoreRepository;


    @InjectMocks
    private StatsServiceImpl statsService;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getHighestScore() {
        when(playerScoreRepository.findHighestScore(1)).thenReturn(new HighestScore() {
            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public String getPlayerName() {
                return "Alex";
            }

            @Override
            public Integer getHighestScore() {
                return 100;
            }
        });
        ResponseEntity responseEntity = statsService.getHighestScore(1);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());
    }

    @Test
    void getBestBattingStrikeRate() {
        when(playerScoreRepository.findBestBattingStrikeRate(1)).thenReturn(new BestBattingStrikeRate() {
            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public String getPlayerName() {
                return "Alex";
            }

            @Override
            public Float getBestBattingStrikeRate() {
                return Float.valueOf(125);
            }
        });
        ResponseEntity responseEntity = statsService.getBestBattingStrikeRate(1);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());
    }

    @Test
    void getBestEconomy() {
        when(playerScoreRepository.findBestEconomy(1)).thenReturn(new BestEconomy() {
            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public String getPlayerName() {
                return "Alex";
            }

            @Override
            public Float getBestEconomy() {
                return Float.valueOf(10);
            }
        });
        ResponseEntity responseEntity = statsService.getBestEconomy(1);
        MainResponse response = (MainResponse) responseEntity.getBody();
        assertEquals("Success", response.getMessage());
    }
}