package com.commons.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.DTO.CourseDTO;
import com.commons.DTO.CourseOutputDTO;
import com.commons.DTO.StudentAddressDTO;
import com.commons.DTO.StudentCourse;
import com.commons.DTO.StudentInputDTO;
import com.commons.DTO.StudentOutputDTO;
import com.commons.exception.CourseException;
import com.commons.exception.StudentException;
import com.commons.model.Address;
import com.commons.model.Course;
import com.commons.model.Student;
import com.commons.repository.AddressRepository;
import com.commons.repository.CourseRepository;
import com.commons.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public StudentOutputDTO updateEmailAndMobile(StudentInputDTO dto) throws StudentException {

        Optional<Student> optional= studentRepository.findById(dto.getStudentId());
        
        if(!optional.isPresent()) {
        	
        	throw new StudentException("student not registered with "+dto.getStudentId());
        }
        
        Student student= optional.get();
        
        student.setEmail(dto.getEmail());
        student.setMobileNumber(dto.getMobileNumber());
        
       Student savedStudent= studentRepository.save(student);
        
       StudentOutputDTO studentOutputDTO=new StudentOutputDTO();
       
       BeanUtils.copyProperties(savedStudent, studentOutputDTO);
		
		return studentOutputDTO;
	}

	@Override
	public StudentOutputDTO updateStudentAddress(StudentAddressDTO addressDTO) throws StudentException {


		Optional<Student> optional= studentRepository.findById(addressDTO.getStudentId());
		
		if(!optional.isPresent()) {
			
			throw new StudentException("student not registered with "+addressDTO.getStudentId());
		}
		
		Student student= optional.get();
		
		List<Address> addressList=student.getAddresses();
		
		for(Address address : addressList) {
			if(address.getAddressId().equals(addressDTO.getAddress().getAddressId())) {
		        
				addressRepository.save(addressDTO.getAddress()) ;
				
			}
		}
	
		 Student savedStudent=  studentRepository.save(student);
		 
		 StudentOutputDTO studentOutputDTO=new StudentOutputDTO();
	       
	       BeanUtils.copyProperties(savedStudent, studentOutputDTO);
			
			return studentOutputDTO;
	}

	@Override
	public StudentCourse getStudentCourses(Integer studentId) throws StudentException {


		Optional<Student> optional= studentRepository.findById(studentId);
		
		if(!optional.isPresent()) {
			
			throw new StudentException("student not registered with "+studentId);
		}
		
	 	Student student= optional.get();
	 	
	 	List<Course> courses=student.getCourses();
	 	
	 	return coursesToStudentCourse(courses, student);
	}

	@Override
	public StudentCourse leaveCourse(Integer studentId, Integer courseId)
			throws StudentException, CourseException {

		Course course = courseRepository.findById(courseId).orElseThrow(()-> new CourseException("Invalid courseId: "+courseId)) ;

		Optional<Student> optional = studentRepository.findById(studentId) ;
		
		if(!optional.isPresent()) {
			
			throw new StudentException("student not registered with "+studentId);
		}
		
		Student student= optional.get();
		
		if(student.getCourses().contains(course)) {
			student.getCourses().remove(course) ;
		}
		
		if(course.getStudents().contains(student)) {
			course.getStudents().remove(student) ;
		}
		courseRepository.save(course) ;
		
		student = studentRepository.save(student) ;
		
		return coursesToStudentCourse(student.getCourses(), student);
		
	}
	
	
	@Override
	public StudentCourse coursesToStudentCourse(List<Course> courses,Student student) {
		
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudentId(student.getStudentCode());
		studentCourse.setName(student.getStudentName());
		
		List<CourseDTO> courseDTOList = new ArrayList<>();
		for(Course singleCourse : student.getCourses()) {
			
			CourseDTO dto = new CourseDTO();
			BeanUtils.copyProperties(singleCourse, dto);
			courseDTOList.add(dto) ;
		}
		
		studentCourse.setCourses(courseDTOList);
		
		return studentCourse;
	}

	@Override
	public List<Address> addNewAddress(StudentAddressDTO addressDTO) throws StudentException {

              Optional<Student> optional=  studentRepository.findById(addressDTO.getStudentId());
              
              
              if(!optional.isPresent()) {
            	  
            	  throw new StudentException("student not registered with "+addressDTO.getStudentId());
              }
		
		List<Address> addressList =optional.get().getAddresses();
		
		
		
		
		List<Address> filterAddress = addressList.stream().filter(address -> address.getType().equals(addressDTO.getAddress().getType())).collect(Collectors.toList());
		
		if(filterAddress.size() != 0) 
			throw new StudentException("Address type : "+ addressDTO.getAddress().getType() +" is already added!. You have to update the address") ;
		
		optional.get().getAddresses().add(addressDTO.getAddress()) ;
		Student updateStudent = studentRepository.save(optional.get());
		
		
		
		
		return updateStudent.getAddresses();
		
	}

}
