package com.example.cricket.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.cricket.request.LoginRequest;
import com.example.cricket.request.SignUpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class) 
class AuthControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext appContext;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@BeforeEach
	void init()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(appContext).build();
	}

	@Test
	void userLoginTest() throws Exception {
		
		LoginRequest request = new LoginRequest("shrilakshmi.adiga12@gmail.com","adiga123");
		String jsonRequest = mapper.writeValueAsString(request);
		mockMvc.perform(post("/auth/login")
				.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is2xxSuccessful())
				.andReturn();
	}
	
	@Test
	void userSigninTest() throws Exception
	{
		SignUpRequest request = new SignUpRequest("a1@gail.com","b", "c",null,"e,","f","g","h");
		String jsonRequest = mapper.writeValueAsString(request);
		
			mockMvc.perform(post("/auth/signUp")
				.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is2xxSuccessful())
				.andReturn();

	}

	@Test
	void adminRegisterTest() throws Exception
	{
				mockMvc.perform(post("/auth/adminRegister?email=admin@gmail.com"))
				.andExpect(status().is2xxSuccessful())
				.andReturn();
	}
	
	@Test
	void adminUpdateTest() throws Exception
	{
		SignUpRequest request = new SignUpRequest("admin@gmail.com","b", "c",null,"e,","f","g","h");
		String jsonRequest = mapper.writeValueAsString(request);
				mockMvc.perform(post("/auth/adminUpdate")
				.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is2xxSuccessful())
				.andReturn();

	}
	
}
