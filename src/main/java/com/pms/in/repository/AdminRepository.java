package com.pms.in.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.in.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	public abstract Admin findByAdminName(String adminName);

	public abstract Admin findByPassword(String password);
	
	
}
