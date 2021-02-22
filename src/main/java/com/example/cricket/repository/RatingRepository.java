package com.example.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cricket.model.GroundEntity;
import com.example.cricket.model.Rating;

public interface RatingRepository extends JpaRepository<Rating,Long> {
	@Query(value = "select sum(rating)/count(rating_id) from Cricket.app_rating;", nativeQuery = true)
	float findOverallRating();

}
