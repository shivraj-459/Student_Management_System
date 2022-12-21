package com.commons.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentCode;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String studentName; 
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String DOB;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String email;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	
	@NotNull
	private String parentName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses=new ArrayList<>();

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
	private List<Course> courses=new ArrayList<>();


	@Override
	public int hashCode() {
		return Objects.hash(DOB, email, gender, mobileNumber, parentName, studentCode, studentName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(DOB, other.DOB)
				&& Objects.equals(email, other.email) && gender == other.gender
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(parentName, other.parentName)
				&& Objects.equals(studentCode, other.studentCode) && Objects.equals(studentName, other.studentName);
	}


	public Integer getStudentCode() {
		return studentCode;
	}


	public void setStudentCode(Integer studentCode) {
		this.studentCode = studentCode;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}




	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public Student() {
		super();
	}


	public Student(String studentName, Gender gender, String dOB, String email, String mobileNumber,
			String parentName) {
		super();
		this.studentName = studentName;
		this.gender = gender;
		DOB = dOB;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.parentName = parentName;
	}
	
	
	
	

}
