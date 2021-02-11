package com.example.cricket.controller;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.TournamentGround;
import com.example.cricket.service.GroundService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
class GroundControllerTest {

    private MockMvc mockMvc;

    @MockBean
    GroundService groundService;

    @Autowired
    GroundController groundController;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.groundController).build();
    }

    @Test
    void addGround() throws Exception {
        String json = "{\"name\":\"\",\"city\":\"\",\"latitude\":\"\",\"longitude\":\"\",\"imagePath\":\"\"}";
        given(groundService.addGround(new GroundEntity())).willReturn(new ResponseEntity<>(HttpStatus.ACCEPTED));
        mockMvc.perform(
                post("/addGround").contentType(
                        MediaType.APPLICATION_JSON).content(json)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void getAllGround() throws Exception {
        given(groundService.getAllGround()).willReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(
                get("/getAllGround").contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().is2xxSuccessful());
    }

    @Test
    void tournamentGround() throws Exception {
        String json = "{\"tournamentId\":\"1\",\"groundId\":\"1\"}";
        given(groundService.tournamentGround(new TournamentGround())).willReturn(new ResponseEntity<>(HttpStatus.CREATED));
        mockMvc.perform(
                put("/tournamentGround").contentType(
                        MediaType.APPLICATION_JSON).content(json)).andExpect(
                status().is2xxSuccessful());
    }
}