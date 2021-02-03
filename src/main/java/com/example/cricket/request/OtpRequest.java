package com.example.cricket.request;

public class OtpRequest {
	private String email;
	private long otpNumber;
	
	public OtpRequest() {
		
	}
	
	public OtpRequest(String email, long otpNumber) {
		super();
		this.email = email;
		this.otpNumber = otpNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getOtpNumber() {
		return otpNumber;
	}

	public void setOtpNumber(long otpNumber) {
		this.otpNumber = otpNumber;
	}
	
	
	
	
	
	

}
