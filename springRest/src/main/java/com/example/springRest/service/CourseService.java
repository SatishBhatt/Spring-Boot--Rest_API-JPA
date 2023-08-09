package com.example.springRest.service;

import java.util.List;

import com.example.springRest.entity.Courses;

public interface CourseService {
	
	public List<Courses> getCourses();
	public Courses getCourse(Long courseId);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses course);
	public void deleteCourse(Long courseId);
}
