package com.pms.in.controller;

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

import com.pms.in.controller.PensionController;
import com.pms.in.entities.PensionDetails;
import com.pms.in.service.PensionService;

@RestController
public class PensionController {

	private static final Logger LOG = LoggerFactory.getLogger(PensionController.class);

	@Autowired
	private PensionService pensionService;

	@PostMapping(path = "/addpension")
	public ResponseEntity<PensionDetails> addPension(@RequestBody PensionDetails pensionDetails) {
		LOG.info("ControlleraddPension");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "pension details added successfully.");
		return new ResponseEntity<PensionDetails>(pensionService.addPensionDetails(pensionDetails), headers,
				HttpStatus.CREATED);

	}

	@PutMapping("/updatepension")
	public ResponseEntity<PensionDetails> updatepension(@RequestBody PensionDetails pensionDetails) {
		LOG.info("Controllerupdatepension");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "pension details updated successfully.");
		return new ResponseEntity<PensionDetails>(pensionService.updatePensionDetails(pensionDetails), headers,
				HttpStatus.CREATED);

	}

	@GetMapping("/getpensiondetailsbyid/{pensionid}")
	public ResponseEntity<PensionDetails> viewPension(@PathVariable(name = "pensionid") int pensionid) {
		LOG.info("ControllerviewPension");
		PensionDetails pensionDetails = pensionService.viewPensionDetails(pensionid);
		LOG.info(pensionDetails.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This pension details is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<PensionDetails> response = new ResponseEntity<PensionDetails>(pensionDetails, headers,
				HttpStatus.OK);
		return response;

	}

	@DeleteMapping("/deletepensionbyid/{pensionid}")
	public ResponseEntity<PensionDetails> deletePension(@PathVariable int pensionid) {
		LOG.info("ControllerdeletePension");
		PensionDetails pensionDetails = pensionService.deletePensionDetails(pensionid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Pension deleted successfully.");
		ResponseEntity<PensionDetails> response = new ResponseEntity<PensionDetails>(pensionDetails, headers,
				HttpStatus.OK);
		return response;

	}
}