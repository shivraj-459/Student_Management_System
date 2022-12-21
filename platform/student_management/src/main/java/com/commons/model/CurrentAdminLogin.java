package com.commons.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class CurrentAdminLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sessionId;
	
	@Column(unique = true)
	private Integer adminId;
	
	private String uuid;
	
	private LocalDateTime timeStamp;

	
	
	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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

	public CurrentAdminLogin(Integer adminId, String uuid, LocalDateTime timeStamp) {
		super();
		this.adminId = adminId;
		this.uuid = uuid;
		this.timeStamp = timeStamp;
	}
	
	
	public CurrentAdminLogin() {
		
	}
	
	
}
