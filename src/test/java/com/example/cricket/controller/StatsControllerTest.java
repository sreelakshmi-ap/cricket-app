package com.example.cricket.controller;

import com.example.cricket.service.LiveScoreService;
import com.example.cricket.service.StatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
class StatsControllerTest {

    private MockMvc mockMvc;

    @MockBean
    StatsService statsService;

    @Autowired
    StatsController statsController;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.statsController).build();
    }


    @Test
    void getHighestScore() throws Exception {
        given(statsService.getHighestScore(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/getHighestScore/{tournamentId}",1).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void getBestBattingStrikeRate() throws Exception {
        given(statsService.getBestBattingStrikeRate(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/getBestBattingStrikeRate/{tournamentId}",1).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void getBestEconomy() throws Exception {
        given(statsService.getBestEconomy(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/getBestEconomy/{tournamentId}",1).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void getBestBowlingStrikeRate() throws Exception {
        given(statsService.getBestBowlingStrikeRate(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/getBestBowlingStrikeRate/{tournamentId}",1).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }
}