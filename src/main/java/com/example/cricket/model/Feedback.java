package com.example.cricket.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feedback_id;
	@Column
	private long user_id;
	@Column
	private String feedbacks;
	@Column
	LocalDate feedbackDate;
	@Column
	LocalTime feedbackTime;

	public Feedback() {

	}

	public Feedback(long feedback_id, long user_id, String feedbacks, LocalDate feedbackDate, LocalTime feedbackTime) {
		super();
		this.feedback_id = feedback_id;
		this.user_id = user_id;
		this.feedbacks = feedbacks;
		this.feedbackDate = feedbackDate;
		this.feedbackTime = feedbackTime;
	}

	public long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(String feedbacks) {
		this.feedbacks = feedbacks;
	}

	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public LocalTime getFeedbackTime() {
		return feedbackTime;
	}

	public void setFeedbackTime(LocalTime feedbackTime) {
		this.feedbackTime = feedbackTime;
	}

}
