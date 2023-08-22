package com.akshay.restapp.rest;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException() {
		super();
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

}
