package com.commons.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.exception.AdminException;
import com.commons.exception.LoginException;
import com.commons.model.Admin;
import com.commons.model.CurrentAdminLogin;
import com.commons.repository.AdminLoginRepository;
import com.commons.repository.AdminRepository;

@Service
public class AdminLogServiceImpl implements AdminLogService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminLoginRepository adminLoginRepository;
	
	@Override
	public CurrentAdminLogin adminLogin(Admin admin) throws AdminException, LoginException {
		
		Optional<Admin> optional= adminRepository.findByUsername(admin.getUsername());
		
		if(!optional.isPresent()) {
			
			throw new AdminException("admin does not registered..!");
		}
		
		
		
		Admin savedAdmin=optional.get();
		
		 CurrentAdminLogin currentAdminLogin= adminLoginRepository.findByAdminId(savedAdmin.getAdminId());
		 
		 if(currentAdminLogin!=null) {
			 
			 throw new LoginException("Admin already logged in");
		 }
		
		 if(savedAdmin.getUsername().equalsIgnoreCase(admin.getUsername()) && savedAdmin.getPassword().equals(admin.getPassword())) {
			 
			 String uuid= RandomString.generateUuid();
			 
			 CurrentAdminLogin sessionAdminLogin= new CurrentAdminLogin();
			 sessionAdminLogin.setAdminId(savedAdmin.getAdminId());
			 sessionAdminLogin.setUuid(uuid);
			 sessionAdminLogin.setTimeStamp(LocalDateTime.now());
			 
			CurrentAdminLogin adminLogin= adminLoginRepository.save(sessionAdminLogin);
			 
			 return adminLogin;
		 }
		 else {
			 throw new LoginException("password incorrect..!");
		 }
			
		
	}

	@Override
	public String adminLogout(String uuid) throws LoginException, AdminException {
		
		CurrentAdminLogin admin= adminLoginRepository.findByUuid(uuid);
		
		if(admin==null) {
			
			
			throw new LoginException("Admin is already logged out..!");
		}
		
		 adminLoginRepository.delete(admin);
		
		
		return "Logged Out..!";
	}

}
