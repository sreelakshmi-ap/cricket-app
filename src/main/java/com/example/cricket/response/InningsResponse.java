package com.example.cricket.response;

import org.springframework.http.HttpStatus;

public class InningsResponse {
	
	int match_id;
	
	int innings;
	
	String message;
	
	HttpStatus responseStatus;
	
	

	public InningsResponse() {
		super();
	}



	public InningsResponse(int match_id, int innings, String message, HttpStatus responseStatus) {
		super();
		this.match_id = match_id;
		this.innings = innings;
		this.message = message;
		this.responseStatus = responseStatus;
	}



	public int getMatch_id() {
		return match_id;
	}



	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}



	public int getInnings() {
		return innings;
	}



	public void setInnings(int innings) {
		this.innings = innings;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public HttpStatus getResponseStatus() {
		return responseStatus;
	}



	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
	
	

}
