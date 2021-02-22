package com.example.cricket.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "app_rating")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rating_id;
	@Column
	private long user_id;
	@Column
	private long rating;
	@Column
	LocalDate ratingDate;
	@Column
	LocalTime ratingTime;
	
	public Rating() {
		
	}
	public Rating(long rating_id, long user_id, long rating, LocalDate ratingDate, LocalTime ratingTime) {
		super();
		this.rating_id = rating_id;
		this.user_id = user_id;
		this.rating = rating;
		this.ratingDate = ratingDate;
		this.ratingTime = ratingTime;
	}
	
	public long getRating_id() {
		return rating_id;
	}
	public void setRating_id(long rating_id) {
		this.rating_id = rating_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
	public LocalDate getRatingDate() {
		return ratingDate;
	}
	public void setRatingDate(LocalDate ratingDate) {
		this.ratingDate = ratingDate;
	}
	public LocalTime getRatingTime() {
		return ratingTime;
	}
	public void setRatingTime(LocalTime ratingTime) {
		this.ratingTime = ratingTime;
	}
	
	
	
	

}
