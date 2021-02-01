package com.example.cricket.request;

public class SignUpRequest {
	
	String email;
	String name;
	String countryCode;
	Long phoneNumber;
	String imagePath;
	String gender;
	String password;
	String city;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public SignUpRequest(String email, String name, String countryCode, Long phoneNumber, String imagePath,
			String gender, String password, String city) {
		this.email = email;
		this.name = name;
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.imagePath = imagePath;
		this.gender = gender;
		this.password = password;
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public SignUpRequest() {
	}


}
