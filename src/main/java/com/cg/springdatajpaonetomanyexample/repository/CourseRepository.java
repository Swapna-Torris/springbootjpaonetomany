package com.cg.springdatajpaonetomanyexample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springdatajpaonetomanyexample.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByInstructorId(Long instructorId);
	Course findByCourseTitle(String courseTitle);
	Optional<Course> findByIdAndInstructorId(Long courseId,Long instructorId);
	
}
