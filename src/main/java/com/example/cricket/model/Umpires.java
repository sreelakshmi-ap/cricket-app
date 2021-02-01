package com.example.cricket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Umpires")
public class Umpires {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int umpire_id;
	
	String umpire_name;
	String city;
	long phone_number;
	String image_path;
	
	
	public Umpires(String umpire_name, String city, long phone_number,String image_path) {
		super();
		this.umpire_name = umpire_name;
		this.city = city;
		this.phone_number = phone_number;
		this.image_path=image_path;
	}


	public Umpires() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getUmpire_id() {
		return umpire_id;
	}


	public void setUmpire_id(int umpire_id) {
		this.umpire_id = umpire_id;
	}


	public String getUmpire_name() {
		return umpire_name;
	}


	public void setUmpire_name(String umpire_name) {
		this.umpire_name = umpire_name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public long getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}


	public String getImage_path() {
		return image_path;
	}


	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
	
	
	
	

}
