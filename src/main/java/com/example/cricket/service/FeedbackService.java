package com.example.cricket.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.cricket.model.Feedback;
import com.example.cricket.model.Users;
import com.example.cricket.repository.FeedbackRepository;
import com.example.cricket.repository.UsersRepository;
import com.example.cricket.request.feedbackRequest;
import com.example.cricket.response.MainResponse;
import com.example.cricket.response.MessageResponse;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;

	@Autowired
	UsersRepository userDao;

	@Autowired
	public MailService emailService;

	public ResponseEntity<?> feedbackDetails(feedbackRequest feedbackValues) {

		Feedback values = new Feedback();

		Users user = userDao.findByUserID(feedbackValues.getUserId());
		if (user == null) {
			return ResponseEntity.status(404).body(new MessageResponse("user dosen't exist", HttpStatus.NOT_FOUND));

		}
		if (user.getEmail().isEmpty()) {
			return ResponseEntity.status(404).body(new MessageResponse("email doesn't exist", HttpStatus.NOT_FOUND));

		}

		emailService.sendFeedback(user.getEmail(), feedbackValues.getFeedback());

		values.setUser_id(feedbackValues.getUserId());
		values.setFeedbacks(feedbackValues.getFeedback());
		values.setFeedbackDate(LocalDate.now());
		values.setFeedbackTime(LocalTime.now());
		feedbackRepository.save(values);

		return ResponseEntity.status(200).body(new MessageResponse("Feedback added successfully", HttpStatus.OK));

	}

	public ResponseEntity<?> getFeedback(long feedbackId) {
		Optional<Feedback> feedback = feedbackRepository.findByFeedbackId(feedbackId);
		if (feedback.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new MainResponse(200, "Success", feedback));

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Feedback Not Found", ""));
	}

	public ResponseEntity<?> deleteFeedback(long feedbackId) {

		Optional<Feedback> feedback = feedbackRepository.findByFeedbackId(feedbackId);
		if (feedback.isPresent()) {
			feedbackRepository.deleteById(feedbackId);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new MessageResponse("Feedback deleted successfully", HttpStatus.OK));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MainResponse(409, "Feedback Not Found", ""));

	}
}
