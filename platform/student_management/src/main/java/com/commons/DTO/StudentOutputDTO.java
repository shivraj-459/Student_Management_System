package com.commons.DTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.commons.model.Gender;

import lombok.Data;

@Data
public class StudentOutputDTO {
	
	   private Integer studentCode;
	
	   private String studentName; 
		
		@Enumerated(EnumType.STRING)
		private Gender gender;
		
		private String DOB;
		
		private String email;
		
		private String mobileNumber;
		
		private String parentName;

}
