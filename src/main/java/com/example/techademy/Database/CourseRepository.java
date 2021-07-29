package com.example.techademy.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
 public Course findByCourseName(String courseName);
public Course findByCourseId(Long id);
}
