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

import com.cg.springdatajpaonetomanyexample.entity.Instructor;
import com.cg.springdatajpaonetomanyexample.exception.InstructorNotFoundException;
import com.cg.springdatajpaonetomanyexample.service.IInstructorService;

@RestController
@RequestMapping("api/v1")
public class InstructorController {
	
	@Autowired
	private IInstructorService instrService;
	
	@GetMapping("/instructors")
	public List<Instructor> getInstructors(){
		return instrService.getInstructors();
	}
	
	@PostMapping("/instructors")
	public Instructor addInstructor(@RequestBody Instructor instructor){
		return instrService.addInstructor(instructor);
	}
	
	@GetMapping("/instructors/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable("id")Long instructorId) 
			throws InstructorNotFoundException{
			return instrService.getInstructorById(instructorId);
	
	}
	
	@PutMapping("/instructors/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable("id")Long instrId,@RequestBody Instructor instructor) throws InstructorNotFoundException {
		return instrService.updateInstructor(instrId, instructor);
	}
	
	@DeleteMapping("/instructors/{id}")
	public Map<String, Boolean> deleteInstructor(Long instrId) throws InstructorNotFoundException {
		return instrService.deleteInstructor(instrId);
	}
}
