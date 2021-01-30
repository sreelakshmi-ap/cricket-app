package com.example.cricket.response;

import org.springframework.http.HttpStatus;

public class MessageAndStatusResponse {
	
	String message;
	HttpStatus httpStatus;
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
	public MessageAndStatusResponse(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public MessageAndStatusResponse(String message) {
		this.message = message;
	}


}
