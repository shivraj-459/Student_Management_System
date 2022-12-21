package com.commons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commons.DTO.CourseDTO;
import com.commons.DTO.CourseOutputDTO;
import com.commons.exception.CourseException;
import com.commons.exception.LoginException;
import com.commons.exception.StudentException;
import com.commons.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/addcourses/{adminuuid}")
	public ResponseEntity<CourseOutputDTO> addCourseHandler(@RequestBody CourseDTO courseDTO,@PathVariable("adminuuid") String uuid) throws LoginException, CourseException{
		
		CourseOutputDTO courseOutputDTO= courseService.addCourse(courseDTO, uuid);
		
		return new ResponseEntity<CourseOutputDTO>(courseOutputDTO, HttpStatus.OK);
	}
	
	@PatchMapping("/assigncourses/{courseid}/{studentid}/{adminuuid}")
	public ResponseEntity<CourseOutputDTO> assignCoursesToStudentHandler(@PathVariable("courseid") Integer courseId,@PathVariable("studentid") Integer StudentId,@PathVariable("adminuuid") String uuid) throws StudentException, LoginException, CourseException{
		
	CourseOutputDTO courseOutputDTO =courseService.assignCoursesToStudent(courseId, StudentId, uuid);
	
	return new ResponseEntity<CourseOutputDTO>(courseOutputDTO, HttpStatus.OK);
		
		
	}
}
