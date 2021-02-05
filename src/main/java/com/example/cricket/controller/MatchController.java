package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.response.InningsResponse;
import com.example.cricket.service.MatchService;
@RestController
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	@PostMapping("/setInnings")
	public InningsResponse setInnings(int match_id,int innings)
	{
		return matchService.setInnings(match_id, innings);
	}

}
