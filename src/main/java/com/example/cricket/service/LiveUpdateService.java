package com.example.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket.model.LiveUpdate;
import com.example.cricket.repository.LiveUpdateRepository;

@Service
public class LiveUpdateService {
	@Autowired
	LiveUpdateRepository liveUpdateRepository;

	public LiveUpdate UpdateLiveScore(LiveUpdate liveUpdate) {
		return liveUpdateRepository.save(liveUpdate);
	}
}
