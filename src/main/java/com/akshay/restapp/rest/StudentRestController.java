package com.akshay.restapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.restapp.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents;
	
	// define a @PostConstruct to load data only once..
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Akshay", "Gothe"));
		theStudents.add(new Student("Shubham", "Shinde"));
		theStudents.add(new Student("Khushal", "Netake"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if(studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id Not Found - " + studentId);
		}
		return theStudents.get(studentId);
	}
	
}
