package com.example.cricket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cricket.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	@Query(value = "SELECT * FROM feedback WHERE feedback_id = ?1", nativeQuery = true)
	Optional<Feedback> findByFeedbackId(long id);

}
