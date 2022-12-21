package com.commons.service;

import java.util.List;

import com.commons.DTO.AdminDTO;
import com.commons.DTO.StudentOutputDTO;
import com.commons.exception.AdminException;
import com.commons.exception.CourseException;
import com.commons.exception.LoginException;
import com.commons.exception.StudentException;
import com.commons.exception.ValidationException;
import com.commons.model.Admin;
import com.commons.model.Student;

public interface AdminService {
	
	
	public AdminDTO addAdmin(Admin admin) throws AdminException,ValidationException;
	
	public StudentOutputDTO addStudent(Student student,String uuid) throws StudentException,AdminException,LoginException;
	
	public List<StudentOutputDTO> getStudentByName(String name,String uuid)throws StudentException,LoginException;
	
	public List<StudentOutputDTO> getStudentByCourse(Integer courseId,String uuid) throws CourseException,StudentException,LoginException;
	
}
