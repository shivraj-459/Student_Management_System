package com.commons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commons.exception.AdminException;
import com.commons.exception.LoginException;
import com.commons.model.Admin;
import com.commons.model.CurrentAdminLogin;
import com.commons.service.AdminLogService;

@RestController
public class AdminLogController {

	@Autowired
	private AdminLogService adminLogService;
	
	@PostMapping("/adminlogin")
	public ResponseEntity<CurrentAdminLogin> adminLoginHandler(@RequestBody Admin admin) throws AdminException, LoginException{
		
      CurrentAdminLogin	currentAdminLogin=	adminLogService.adminLogin(admin);
      
      return new ResponseEntity<CurrentAdminLogin>(currentAdminLogin,HttpStatus.OK);
      
	}
	
	@DeleteMapping("/adminlogout/{uuid}")
	public ResponseEntity<String> adminLogoutHandler(@PathVariable("uuid") String uuid) throws LoginException, AdminException{
		
		String string=adminLogService.adminLogout(uuid);
		
		
		return new ResponseEntity<String>(string,HttpStatus.OK);
		
	}
	
	
}
