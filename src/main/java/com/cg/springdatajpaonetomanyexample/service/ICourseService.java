package com.cg.springdatajpaonetomanyexample.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.springdatajpaonetomanyexample.entity.Course;

import com.cg.springdatajpaonetomanyexample.exception.CourseNotFoundException;
import com.cg.springdatajpaonetomanyexample.exception.InstructorNotFoundException;


public interface ICourseService {
	public List<Course> getCourses();
	public ResponseEntity<Course> getCourseById(Long cid) throws CourseNotFoundException;
	public Course addCourse(Long instrId,Course course) throws InstructorNotFoundException;
	public Course updateCourse(Long instrId,Long cid,Course course) throws InstructorNotFoundException, CourseNotFoundException;
	public ResponseEntity<?> deleteCourse(Long instructorId,Long cid) throws InstructorNotFoundException, CourseNotFoundException;
	List<Course> findByInstructorId(Long instructorId);
	Optional<Course> findByCourseIdAndInstructorId(Long courseId,Long instructorId);
}
