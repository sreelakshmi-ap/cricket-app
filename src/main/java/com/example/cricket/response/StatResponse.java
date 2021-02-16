package com.example.cricket.response;

public class StatResponse {
	private int status;
	private String message;
	private Object playerDetails;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getPlayerDetails() {
		return playerDetails;
	}
	public void setPlayerDetails(Object playerDetails) {
		this.playerDetails = playerDetails;
	}
	
	public StatResponse() {
		
	}
	public StatResponse(int status, String message, Object playerDetails) {
		super();
		this.status = status;
		this.message = message;
		this.playerDetails = playerDetails;
	}
	
	
	

}
