package com.commons.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.commons.model.CourseType;

import lombok.Data;


public class CourseDTO {

	
	private String courseName;
	
	private String description;
	
	private String duration;
	
	@Enumerated(EnumType.STRING)
	private CourseType type;
	
	@ElementCollection
	private List<String> topics=new ArrayList<>();

	
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public CourseType getType() {
		return type;
	}

	public void setType(CourseType type) {
		this.type = type;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	
	
	public CourseDTO() {
		// TODO Auto-generated constructor stub
	}

	public CourseDTO(String courseName, String description, String duration, CourseType type, List<String> topics) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.duration = duration;
		this.type = type;
		this.topics = topics;
	}
	
	
}
