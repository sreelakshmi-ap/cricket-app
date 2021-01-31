package com.example.cricket.response;

import org.springframework.http.HttpStatus;

public class MessageResponse {

	private String message;
	private HttpStatus httpStatus;

	public MessageResponse() {
		super();
	}

	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public MessageResponse(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
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

}
