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

import com.pms.in.entities.AbstractUser;
import com.pms.in.service.AbstractUserService;

@RestController
public class AbstractUserController {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractUserController.class);

	@Autowired
	private AbstractUserService userService;

	@PostMapping("/register")
	public ResponseEntity<AbstractUser> register(@RequestBody AbstractUser abstractUser) {
		LOG.info("Controllerregister");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User registered successfully.");
		LOG.info(headers.toString());
		return new ResponseEntity<AbstractUser>(userService.register(abstractUser), headers, HttpStatus.CREATED);
	}

	@PutMapping("/login/{user}/{password}")
	public ResponseEntity<AbstractUser> login(@PathVariable(name="user") String userName,@PathVariable(name="password") String password) {
	LOG.info("Controller Login");
	AbstractUser au = userService.login(userName,password); // line 
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "User logged in successfully");
	LOG.info(headers.toString());
	ResponseEntity<AbstractUser> response = new ResponseEntity<AbstractUser>(au, headers, HttpStatus.OK);
	return response;
}

	@PutMapping("/logout")
	public ResponseEntity<String> logout(@RequestBody String userName) {
		LOG.info("Controllerlogout");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User logged out successfully.");
		LOG.info(headers.toString());
		return new ResponseEntity<String>(userService.logout(userName), headers, HttpStatus.OK);
	}
}