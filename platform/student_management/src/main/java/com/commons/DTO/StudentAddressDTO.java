package com.commons.DTO;

import com.commons.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddressDTO {
	
	private Integer studentId;
	
	private String dob;
	
	private Address address;

}
