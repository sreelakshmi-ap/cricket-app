package com.example.cricket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.Feedback;
import com.example.cricket.repository.FeedbackRepository;
import com.example.cricket.repository.UsersRepository;
import com.example.cricket.request.feedbackRequest;
import com.example.cricket.response.MainResponse;
import com.example.cricket.response.MessageResponse;
import com.example.cricket.service.FeedbackService;
import com.example.cricket.service.MailService;

@RestController
@CrossOrigin
public class FeedbackController {

	@Autowired
	FeedbackRepository feedbackRepository;

	@Autowired
	UsersRepository userDao;

	@Autowired
	public MailService emailService;

	@Autowired
	FeedbackService feedbackService;


	@PreAuthorize("hasRole('USER')")
	@PostMapping("/feedback")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> feedbackDetails(@RequestBody feedbackRequest feedbackValues) {
		return feedbackService.feedbackDetails(feedbackValues);
	}

  @PreAuthorize("hasRole('USER')")
	@GetMapping("/getFeedback")
	public ResponseEntity<?> getFeedback(@RequestParam long feedbackId) {
		return feedbackService.getFeedback(feedbackId);
	}


  @PreAuthorize("hasRole('USER')")
	@DeleteMapping("/deleteFeedback")
	public ResponseEntity<?> deleteFeedback(@RequestParam long feedbackId) {
		return feedbackService.deleteFeedback(feedbackId);
	
	}

}
