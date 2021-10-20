package com.cg.springdatajpaonetomanyexample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.springdatajpaonetomanyexample.entity.Course;
import com.cg.springdatajpaonetomanyexample.entity.Instructor;
import com.cg.springdatajpaonetomanyexample.exception.CourseNotFoundException;
import com.cg.springdatajpaonetomanyexample.exception.InstructorNotFoundException;
import com.cg.springdatajpaonetomanyexample.repository.CourseRepository;
import com.cg.springdatajpaonetomanyexample.repository.InstructorRepository;

@Service
public class CourseServiceImpl implements ICourseService{
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private InstructorRepository instrRepository;

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public ResponseEntity<Course> getCourseById(Long cId) throws CourseNotFoundException {
		Course course = courseRepo.findById(cId)
				.orElseThrow(() -> new CourseNotFoundException("Instructor not found :: " +cId));
		return ResponseEntity.ok().body(course);
	}

	@Override
	public Course addCourse(Long instrId,Course course) throws InstructorNotFoundException {
		// TODO Auto-generated method stub
		return instrRepository.findById(instrId).map(instructor ->{
			course.setInstructor(instructor);
			return courseRepo.save(course);
		}).orElseThrow(() -> new InstructorNotFoundException("Instructor not found"));
	}

	@Override
	public Course updateCourse(Long instrId,Long cId,Course course)
			throws InstructorNotFoundException, CourseNotFoundException {
			if(!instrRepository.existsById(instrId)) {
				throw new InstructorNotFoundException("Instructor id not found");
			}
			return courseRepo.findById(cId).map(updatecourse -> {
					updatecourse.setCourseTitle(course.getCourseTitle());
					return courseRepo.save(updatecourse);
			}).orElseThrow(() -> new CourseNotFoundException("Course id not found"));

	}

	@Override
	public ResponseEntity<?> deleteCourse(Long instructorId,Long cid) throws CourseNotFoundException {
			return courseRepo.findByIdAndInstructorId(cid, instructorId)
					.map(course ->{
						courseRepo.delete(course);
						return ResponseEntity.ok().build();
					}).orElseThrow(
						() -> new CourseNotFoundException
						("course not found with id " + cid + "and Instructor id"+instructorId));
	}

	@Override
	public List<Course> findByInstructorId(Long instructorId) {
		// TODO Auto-generated method stub
		return courseRepo.findByInstructorId(instructorId);
	}

	@Override
	public Optional<Course> findByCourseIdAndInstructorId(Long courseId, Long instructorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
