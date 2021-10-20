package com.cg.springdatajpaonetomanyexample.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.cg.springdatajpaonetomanyexample.entity.Instructor;
import com.cg.springdatajpaonetomanyexample.exception.InstructorNotFoundException;

public interface IInstructorService {
	
	public List<Instructor> getInstructors();
	public ResponseEntity<Instructor> getInstructorById(Long id) throws InstructorNotFoundException;
	public Instructor addInstructor(Instructor instructor);
	public ResponseEntity<Instructor> updateInstructor(Long id,Instructor instructor) throws InstructorNotFoundException;;
	public Map<String,Boolean> deleteInstructor(Long id) throws InstructorNotFoundException;
}
