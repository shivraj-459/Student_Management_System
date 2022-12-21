package com.commons.service;

import com.commons.DTO.CourseDTO;
import com.commons.DTO.CourseOutputDTO;
import com.commons.exception.CourseException;
import com.commons.exception.LoginException;
import com.commons.exception.StudentException;

public interface CourseService {
	
	
	public CourseOutputDTO addCourse(CourseDTO courseDTO,String uuid) throws LoginException,CourseException;
	
	public CourseOutputDTO assignCoursesToStudent(Integer courseId,Integer studentId,String uuid) throws StudentException,LoginException,CourseException;

}
