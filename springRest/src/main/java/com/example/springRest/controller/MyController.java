package com.example.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springRest.entity.Courses;
import com.example.springRest.service.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService c_service;

	//get all the courses
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		
		return this.c_service.getCourses();
	}
	
	
	//get a single course whose id is passes
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return this.c_service.getCourse(Long.parseLong(courseId));	
	}
	
	//add new Course
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses courses) {
		return this.c_service.addCourse(courses);	
	}
	
	//update an existing course
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses courses) {
		return this.c_service.updateCourse(courses);	
	}
	
	//delete course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.c_service.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
}
