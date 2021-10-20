package com.cg.springdatajpaonetomanyexample.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springdatajpaonetomanyexample.entity.Course;

import com.cg.springdatajpaonetomanyexample.exception.CourseNotFoundException;
import com.cg.springdatajpaonetomanyexample.exception.InstructorNotFoundException;
import com.cg.springdatajpaonetomanyexample.service.ICourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/v1")
@Api(value = "Spring Boot One to Many",
description = "Operations of the course entity")
public class CourseController {
	
	@Autowired
	private ICourseService cService;
	

	@ApiOperation(value = "view courses by instructor",response = List.class)
	@GetMapping("/instructors/{instructorId}/courses")
	public List<Course> getCourseByInstructor(@PathVariable("instructorId") Long instrId){
		return cService.findByInstructorId(instrId);
	}

	@ApiOperation(value = "add courses to instructor",response = Course.class)
	@PostMapping("/instructors/{instructorId}/courses")
	public Course addCourse
	(@PathVariable("instructorId")Long instrId,@ApiParam(value="Course object stores in the database ",required = true)@RequestBody Course course)
			throws InstructorNotFoundException{
		
		return cService.addCourse(instrId,course);
	}
	
	@ApiOperation(value = "modify courses by instructor",response = Course.class)
	@ApiResponses(value= {
			@ApiResponse(code = 200,message="successfully updated the course"),
			@ApiResponse(code = 401,message="you are not authorised to update the course"),
			@ApiResponse(code = 404,message="Course not found")
	})
	@PutMapping("/instructors/{instructorId}/courses/{id}")
	public Course updatecourse(@PathVariable("instructorId")Long instructorId,
			@PathVariable("id")Long courseId,@RequestBody Course course) throws InstructorNotFoundException 
	, CourseNotFoundException{
		return cService.updateCourse(instructorId, courseId,course);
	}
	
	
	/*
	 * @GetMapping("/courses/{id}") public ResponseEntity<Course>
	 * getCourseById(@PathVariable("id")Long cId) throws CourseNotFoundException{
	 * return cService.getCourseById(cId); }
	 */
	@ApiOperation(value = "delete courses by instructor and course",response = ResponseEntity.class)
	@DeleteMapping("/instructors/{instructorId}/courses/{id}")
	public  ResponseEntity<?> deleteCourse(@PathVariable("instructorId")Long instrId,@PathVariable("id")Long cId) throws CourseNotFoundException, InstructorNotFoundException {
		return cService.deleteCourse(instrId,cId);
	}
}
