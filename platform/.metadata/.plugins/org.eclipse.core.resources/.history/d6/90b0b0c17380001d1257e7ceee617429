package com.commons.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class CurrentStudentLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sessionId;
	
	private Integer studentId;
	
	private String uuid;
	
	private LocalDateTime timeStamp;

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public CurrentStudentLogin(Integer studentId, String uuid, LocalDateTime timeStamp) {
		super();
		this.studentId = studentId;
		this.uuid = uuid;
		this.timeStamp = timeStamp;
	}
	
	
	public CurrentStudentLogin() {
		
	}

}
