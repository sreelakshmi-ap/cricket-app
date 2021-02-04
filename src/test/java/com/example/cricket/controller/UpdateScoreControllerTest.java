package com.example.cricket.controller;

import com.example.cricket.model.TournamentGround;
import com.example.cricket.request.Toss;
import com.example.cricket.service.GroundService;
import com.example.cricket.service.UpdateScoreService;
import com.google.gson.Gson;
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


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
class UpdateScoreControllerTest {

    private MockMvc mockMvc;

    @MockBean
    UpdateScoreService updateScoreService;

    @Autowired
    UpdateScoreController updateScoreController;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.updateScoreController).build();
    }

    @Test
    void toss() throws Exception {
        String json = "{}";
        given(updateScoreService.toss(new Toss())).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                put("/toss").contentType(
                        MediaType.APPLICATION_JSON).content(json)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void startMatch() throws Exception {
        String json = "{}";
        given(updateScoreService.startMatch(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                put("/startMatch/{matchId}",1).contentType(
                        MediaType.APPLICATION_JSON).content(json)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void batsmenList() throws Exception {
        given(updateScoreService.batsmenList(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/batsmenList/{matchId}",1).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void bowlerList() throws Exception {
        given(updateScoreService.bowlerList(1)).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/bowlerList/{matchId}",1).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void currentPlaying() throws Exception {

    }
}