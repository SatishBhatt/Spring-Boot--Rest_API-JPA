package com.example.springRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springRest.dao.CourseDao;
import com.example.springRest.entity.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao c_dao;

	//List<Courses> list;
	
	public CourseServiceImpl() {
		
	}
	
	@Override
	public List<Courses> getCourses() {
		
		return c_dao.findAll();
	}

	@Override
	public Courses getCourse(Long courseId) {
		Optional<Courses> course = c_dao.findById(courseId);
	    return course.orElse(null); // Handle the case when the course doesn't exist
	}

	@Override
	public Courses addCourse(Courses courses) {
		c_dao.save(courses);
		return null;
	}

	@Override
	public Courses updateCourse(Courses courses) {
		
	
		c_dao.save(courses);
		return courses;
	}

	@Override
	public void deleteCourse(Long courseId) {
		
		c_dao.deleteById(courseId);;
	
	}

	
	
}
