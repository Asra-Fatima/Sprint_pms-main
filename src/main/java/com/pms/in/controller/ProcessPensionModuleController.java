package com.pms.in.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pms.in.entities.PensionDetails;

import com.pms.in.service.PensionDisbursementService;
import com.pms.in.service.PensionerService;

@RestController
public class ProcessPensionModuleController {

	@Autowired
	private PensionerService pensionerService;

	@Autowired
	private PensionDisbursementService pensionDisbursementService;

	private static final Logger LOG = LoggerFactory.getLogger(ProcessPensionModuleController.class);

	@GetMapping("/PensionDetail")
	public ResponseEntity<PensionDetails> getPensionDetail(@RequestParam String name, @RequestParam int pan,
			@RequestParam int aadhar, @RequestParam String type) {

		LOG.info("ControllergetPensionDetail");
		boolean pensionerDetails = pensionerService.validatePensioner(name, pan, aadhar, type);
		if (pensionerDetails == true) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "Validated persioner details.");
			LOG.info(headers.toString());
			PensionDetails pensionDetails = pensionDisbursementService.calculatePension(aadhar);
			boolean pensionOutput = pensionDisbursementService.processPension(pensionDetails);
			if (pensionOutput == true) {
				HttpHeaders header = new HttpHeaders();
				header.add("Success", "10");
				LOG.info(headers.toString());

				ResponseEntity<PensionDetails> response = new ResponseEntity<PensionDetails>(pensionDetails, header,
						HttpStatus.OK);
				return response;

			} else {
				HttpHeaders header = new HttpHeaders();
				header.add("Pension amount calculated is wrong, Please redo the calculation", "21");
				LOG.info(headers.toString());
				ResponseEntity<PensionDetails> response = new ResponseEntity<PensionDetails>(pensionDetails, header,
						HttpStatus.OK);
				return response;

			}

		}
		HttpHeaders heads = new HttpHeaders();
		heads.add("Pension amount calculated is wrong, Please redo the calculation", "21.");
		LOG.info(heads.toString());
		PensionDetails pensionDetails = null;
		ResponseEntity<PensionDetails> response = new ResponseEntity<PensionDetails>(pensionDetails, heads,
				HttpStatus.OK);
		return response;

	}

}
