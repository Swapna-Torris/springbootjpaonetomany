package com.cg.springdatajpaonetomanyexample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.springdatajpaonetomanyexample.entity.Instructor;
import com.cg.springdatajpaonetomanyexample.exception.InstructorNotFoundException;
import com.cg.springdatajpaonetomanyexample.repository.CourseRepository;
import com.cg.springdatajpaonetomanyexample.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements IInstructorService{
	
	@Autowired
	private InstructorRepository instrRepository;
	
	//@Autowired
	//private CourseRepository courseRepository;

	@Override
	public List<Instructor> getInstructors() {
		// TODO Auto-generated method stub
		return instrRepository.findAll();
	}

	@Override
	public ResponseEntity<Instructor> getInstructorById(Long instrId) throws InstructorNotFoundException {
		Instructor instructor = instrRepository.findById(instrId)
				.orElseThrow(() -> new InstructorNotFoundException("Instructor not found :: " +instrId));
		return ResponseEntity.ok().body(instructor);
	}

	@Override
	public Instructor addInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return instrRepository.save(instructor);
	}

	@Override
	public ResponseEntity<Instructor> updateInstructor
	(Long instrId,Instructor instructor) throws InstructorNotFoundException {
		Instructor updateToInstructor = instrRepository.findById(instrId)
				.orElseThrow(() -> new InstructorNotFoundException("Instructor not found :: " +instrId));
		updateToInstructor.setInstrFirstName(instructor.getInstrFirstName());
		updateToInstructor.setInstrLastName(instructor.getInstrLastName());
		updateToInstructor.setInstrEmail(instructor.getInstrEmail());
		final Instructor updatedInstructor = instrRepository.save(updateToInstructor);
		return ResponseEntity.ok(updatedInstructor);
	}

	@Override
	public Map<String, Boolean> deleteInstructor(Long instrId) throws InstructorNotFoundException {
		Instructor instructor = instrRepository.findById(instrId)
				.orElseThrow(() -> new InstructorNotFoundException("Instructor not found :: " +instrId));
		
		instrRepository.delete(instructor);
		 Map<String, Boolean> response = new HashMap<>();
		 response.put("Instructor deleted", Boolean.TRUE);
		 return response;
	}

}
