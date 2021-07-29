package com.example.techademy.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

 public Feedback findByEmail(String email);
}
