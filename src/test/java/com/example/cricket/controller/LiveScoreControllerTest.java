package com.example.cricket.controller;

import com.example.cricket.service.LiveScoreService;
import com.example.cricket.service.UpdateScoreService;
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
class LiveScoreControllerTest {

    private MockMvc mockMvc;

    @MockBean
    LiveScoreService liveScoreService;

    @Autowired
    LiveScoreController liveScoreController;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.liveScoreController).build();
    }


    @Test
    void getLiveScore() throws Exception {
        given(liveScoreService.getLiveScore(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/getLiveScore/{matchId}",1).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void getScoreBoard() throws Exception {
        given(liveScoreService.getScoreBoard(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/getScoreBoard/{matchId}",1).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }
}