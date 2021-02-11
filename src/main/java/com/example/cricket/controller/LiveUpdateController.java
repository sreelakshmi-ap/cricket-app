package com.example.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.LiveUpdate;
import com.example.cricket.request.LiveUpdateRequest;
import com.example.cricket.response.ExtrasCount;
import com.example.cricket.service.LiveUpdateService;

@RestController
public class LiveUpdateController {
	@Autowired
	LiveUpdateService liveUpdateService;

	@PostMapping("/UpdateLiveScore")
	public ResponseEntity<?> UpdateLiveScoreDetails(@RequestBody LiveUpdateRequest liveReq) {
		return liveUpdateService.UpdateLiveScore(liveReq);
	}
	

    @GetMapping("/getCountOfExtras")
    public ExtrasCount getCountOfExtrasDetails(@RequestParam int matchId, @RequestParam int teamId ){
        return liveUpdateService.getCountOfExtras(matchId, teamId);
    }
    
}
