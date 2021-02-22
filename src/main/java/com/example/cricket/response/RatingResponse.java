package com.example.cricket.response;

import org.springframework.http.HttpStatus;

public class RatingResponse {
	
	private String message;
	private HttpStatus httpStatus;
	private float overallRating;
	
	public RatingResponse() {
		
	}
	public RatingResponse(String message, HttpStatus httpStatus, float overallRating) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.overallRating = overallRating;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public float getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(float overallRating) {
		this.overallRating = overallRating;
	}
	
	
	
	

}
