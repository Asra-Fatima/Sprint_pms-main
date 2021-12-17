package com.pms.in.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.in.service.PensionService;
import com.pms.in.repository.PensionRepository;
import com.pms.in.exception.PensionDetailsAlreadyExsitsException;
import com.pms.in.exception.PensionDetailsNotFoundException;
import com.pms.in.entities.PensionDetails;

@Service
public class PensionService implements IPensionService {

	private static final Logger LOG = LoggerFactory.getLogger(IPensionService.class);
	@Autowired
	private PensionRepository pensionRepository;
	
	@Override
	public PensionDetails addPensionDetails(PensionDetails pensionDetails) {

		LOG.info("ServiceAddpension");
		if (!pensionRepository.existsById(pensionDetails.getPensioner_id()) ) {
			LOG.info("Pension Details added");
			return pensionRepository.save(pensionDetails);
		}else {
		LOG.info(pensionDetails.getPensioner_id() + " already exists.");
		throw new PensionDetailsAlreadyExsitsException(pensionDetails.getPensioner_id()+" this pension details already present");
	}
	}

	
	@Override
	public PensionDetails updatePensionDetails(PensionDetails pensionDetails) {
		LOG.info("ServiceupdatePension");
		if (pensionRepository.existsById(pensionDetails.getPensioner_id()) ) {
       LOG.info("pension Details Updated");
			return pensionRepository.save(pensionDetails);
		}else {

			LOG.info("pension details is NOT available.");
			throw new PensionDetailsNotFoundException(pensionDetails.getPensioner_id()+" this pension details  not found.");
		}
		
	}

	@Override
	public PensionDetails viewPensionDetails(int pensionerId) {
		LOG.info("ServiceViewpensiondetails");
		Optional<PensionDetails> empOpt = pensionRepository.findById(pensionerId);
		if (empOpt.isPresent()) {
			LOG.info("pension deatils present");
			return empOpt.get();
		} else {
			LOG.info("pension details is NOT available.");
			throw new PensionDetailsNotFoundException(pensionerId + " this pension details  not found.");
		}
	}

	public PensionDetails deletePensionDetails(int pensionerId) {
		LOG.info("servicedeletepensiondetails");
		Optional<PensionDetails> empOpt = pensionRepository.findById(pensionerId);
		if (empOpt.isPresent()) {
			pensionRepository.deleteById(pensionerId);
			return empOpt.get();
		} else {
			throw new PensionDetailsNotFoundException(pensionerId + " this pension details does not exist.");
		}
	}
	
	
	

}
