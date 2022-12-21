package com.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commons.model.CurrentAdminLogin;

@Repository
public interface AdminLoginRepository extends JpaRepository<CurrentAdminLogin, Integer>{

	public CurrentAdminLogin findByAdminId(Integer adminId);
	
	public CurrentAdminLogin findByUuid(String uuid);
	
}
