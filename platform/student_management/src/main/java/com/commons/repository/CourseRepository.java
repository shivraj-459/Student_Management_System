package com.commons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.commons.model.Course;
import com.commons.model.CourseType;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query("select c from Course c where c.courseName=?1 AND c.type=?2 AND c.duration=?3")
	public Optional<Course> findByCourseNameAndTypeAndDuration(String courseName,CourseType type,String duration); 
	
}
