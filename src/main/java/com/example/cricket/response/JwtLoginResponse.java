package com.example.cricket.response;

import org.springframework.http.HttpStatus;

public class JwtLoginResponse {
	
	String name;
	String imagePath;
	String token;
	String type = "Bearer";
	String email;
	HttpStatus httpStatus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public JwtLoginResponse(String name, String imagePath, String token,String email) {
		this.name = name;
		this.imagePath = imagePath;
		this.token = token;
		this.email = email;
	}
	public JwtLoginResponse(String name, String imagePath, String token, String email, HttpStatus httpStatus) {
		this.name = name;
		this.imagePath = imagePath;
		this.token = token;
		this.email = email;
		this.httpStatus = httpStatus;
	}
	public JwtLoginResponse() {
	}

}
