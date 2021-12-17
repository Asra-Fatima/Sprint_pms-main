package com.pms.in.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.in.entities.Admin;
import com.pms.in.exception.AdminAlreadyExistsException;
import com.pms.in.exception.AdminDoesNotExistsException;
import com.pms.in.exception.IncorrectLoginCredentialsException;
import com.pms.in.repository.AdminRepository;

@Service
public class AdminService implements IAdminService{
	
	public boolean isLoggedIn;

	private Admin tempUser;
	
	private Admin tempPassword;

	private static final Logger LOG = LoggerFactory.getLogger(AbstractUserService.class);

	@Autowired
	AdminRepository adminRepository;

	public Admin register(Admin admin) {
		LOG.info("Serviceregister");
		if (adminRepository.findByAdminName(admin.getAdminName()) != null) {
			LOG.error("Admin already exists");
			throw new AdminAlreadyExistsException();
		} else {
			LOG.info("Register successfully");
			return adminRepository.save(admin);
		}
	}

	@Override
	public Admin login(String username, String password) {
		LOG.info("login");
		this.tempUser = adminRepository.findByAdminName(username);
		this.tempPassword=adminRepository.findByPassword(tempUser.getPassword());
		if (tempUser.getAdminName().equalsIgnoreCase(username) && tempPassword.getPassword().equals(password)) {
			LOG.info("Logged in successfully.");
			isLoggedIn = true;
			return tempUser;
		}
		LOG.error("Admin not found");
		throw new IncorrectLoginCredentialsException();
	}
	
	@Override
	public String logout(String adminName) {
		LOG.info("Servicelogout");
		if (isLoggedIn) {
			isLoggedIn = false;
			return "User logged out successfully.";
		}else {
		LOG.error("User not found");
		throw new AdminDoesNotExistsException();
	}
		
	}

}