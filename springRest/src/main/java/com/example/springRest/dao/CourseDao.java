package com.example.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springRest.entity.Courses;

public interface CourseDao extends JpaRepository<Courses, Long> {

}
