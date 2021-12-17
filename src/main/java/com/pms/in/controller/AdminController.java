package com.pms.in.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.in.entities.Admin;
import com.pms.in.service.AdminService;

@RestController
public class AdminController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractUserController.class);

	@Autowired
	private AdminService adminService;

	@PostMapping("/registertoadmin")
	public ResponseEntity<Admin> register(@RequestBody Admin abstractUser) {
		LOG.info("Controllerregister");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Admin registered successfully.");
		LOG.info(headers.toString());
		return new ResponseEntity<Admin>(adminService.register(abstractUser), headers, HttpStatus.CREATED);
	}

	@PutMapping("/adminlogin/{admin}/{password}")
	public ResponseEntity<Admin> login(@PathVariable(name="admin") String adminName,@PathVariable(name="password") String password) {
	LOG.info("Controller Login");
	Admin ad = adminService.login(adminName,password); // line 
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "Admin logged in successfully");
	LOG.info(headers.toString());
	ResponseEntity<Admin> response = new ResponseEntity<Admin>(ad, headers, HttpStatus.OK);
	return response;
}

	@PutMapping("/adminlogout")
	public ResponseEntity<String> logout(@RequestBody String adminName) {
		LOG.info("Controllerlogout");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Admin logged out successfully.");
		LOG.info(headers.toString());
		return new ResponseEntity<String>(adminService.logout(adminName), headers, HttpStatus.OK);
	}

}
