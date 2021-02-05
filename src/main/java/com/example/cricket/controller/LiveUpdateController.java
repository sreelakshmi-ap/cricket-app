package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.LiveUpdate;
import com.example.cricket.service.LiveUpdateService;

@RestController
public class LiveUpdateController {
	@Autowired
	LiveUpdateService liveUpdateService;

//	@PostMapping("/UpdateLiveScore")
//	public LiveUpdate UpdateLiveScoreDetails(@RequestBody LiveUpdate liveUpdate) {
//		return liveUpdateService.UpdateLiveScore(liveUpdate);
//	}
}
