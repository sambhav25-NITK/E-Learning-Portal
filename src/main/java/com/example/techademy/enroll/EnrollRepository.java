package com.example.techademy.enroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollRepository extends JpaRepository<Enroll,Long> {
    public List<Enroll> findByEnrolledUserId(Long id);
}
