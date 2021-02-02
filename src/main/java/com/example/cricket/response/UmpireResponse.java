package com.example.cricket.response;

import org.springframework.stereotype.Component;

@Component
public class UmpireResponse {
	
	String umpire_name;
	String image_path;
	public String getUmpire_name() {
		return umpire_name;
	}
	public void setUmpire_name(String umpire_name) {
		this.umpire_name = umpire_name;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public UmpireResponse(String umpire_name, String image_path) {
		super();
		this.umpire_name = umpire_name;
		this.image_path = image_path;
	}
	public UmpireResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
