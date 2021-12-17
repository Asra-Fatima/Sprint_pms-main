package com.pms.in.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.in.entities.PensionerDetails;
import com.pms.in.service.PensionerService;

@RestController

public class PensionerController {

	private static final Logger LOG = LoggerFactory.getLogger(PensionerController.class);

	@Autowired
	private PensionerService pensionerService;

	@GetMapping("/getpensioner")
	public ResponseEntity<List<PensionerDetails>> getAllPensionersDetails() {
		LOG.info("ControllergetAllPensionersDetails");
		List<PensionerDetails> list = pensionerService.getAllPensionersDetails();

		return new ResponseEntity<List<PensionerDetails>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/addpensioner")
	public ResponseEntity<PensionerDetails> addpensioner(@RequestBody PensionerDetails pensionerdetails) {
		LOG.info("ControlleraddPensioner");
		PensionerDetails p1 = pensionerService.addPensionerDetails(pensionerdetails);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This pensioner  is added to database.");
		LOG.info(headers.toString());
		ResponseEntity<PensionerDetails> response = new ResponseEntity<PensionerDetails>(p1, headers, HttpStatus.OK);
		return response;
	}

	@PutMapping("/updatepensioner")
	public ResponseEntity<PensionerDetails> updatepensioner(@RequestBody PensionerDetails pensionerdetails) {
		LOG.info("ControllerupdatePensioner");
		PensionerDetails p1 = pensionerService.updatePensionerDetails(pensionerdetails);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This pensioner Details are updated to database.");
		LOG.info(headers.toString());
		ResponseEntity<PensionerDetails> response = new ResponseEntity<PensionerDetails>(p1, headers, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/deletepensioner/{pensioner_id}")
	public ResponseEntity<PensionerDetails> deletePensionerById(@PathVariable int pensioner_id) {
		LOG.info("ControllerdeletePensionerById");
		pensionerService.deletePensionerDetails(pensioner_id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This pensioner is deleted from database.");
		LOG.info(headers.toString());
		ResponseEntity<PensionerDetails> response = new ResponseEntity<PensionerDetails>(headers, HttpStatus.OK);
		return response;
	}

}