package com.cg.springdatajpaonetomanyexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InstructorNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4644043035941001315L;
		public InstructorNotFoundException(String message) {
			// TODO Auto-generated constructor stuber
			super(message);
		}
}
