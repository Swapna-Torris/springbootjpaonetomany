package com.cg.springdatajpaonetomanyexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5301819710604276102L;
	
	public CourseNotFoundException(String message) {
		super(message);
	}

}
