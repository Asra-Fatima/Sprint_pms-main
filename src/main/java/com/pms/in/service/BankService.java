package com.pms.in.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.in.exception.AccountNotFoundException;
import com.pms.in.exception.BankAlreadyExistsException;
import com.pms.in.exception.BankDoesNotExistsException;
import com.pms.in.entities.BankDetails;
import com.pms.in.repository.BankRepository;

@Service
public class BankService implements IBankService {

	private static final Logger LOG = LoggerFactory.getLogger(BankService.class);

	@Autowired
	private BankRepository bankRepository;

	public BankDetails getBankDetails(Long accno) {
		LOG.info("ServicegetBankDetailsById");
		Optional<BankDetails> bankOpt = bankRepository.findById(accno);
		if (bankOpt.isPresent()) {
			LOG.info("bank Details get successfully");
			return bankOpt.get();
		} else {
			LOG.info("Bank does not exists");
			throw new BankDoesNotExistsException("Bank does not exists");
		}
	}

	@Override
	public BankDetails addBank(BankDetails bankDetails) {
		LOG.info("ServiceaddBankDetails");
		if (!bankRepository.existsById(bankDetails.getAccno())) {
			LOG.info("Bank Details added successfully");
			return bankRepository.save(bankDetails);
		} else {
			LOG.info("This bank already exist in the database");
			throw new BankAlreadyExistsException("This bank already exists in the database");
		}
	}

	public BankDetails updateBankDetails(BankDetails bankDetails) {
		LOG.info("ServiceupdateBankDeatils");
		if (bankRepository.existsById(bankDetails.getAccno())) {
			LOG.info("Bank Details update successfully");
			return bankRepository.save(bankDetails);
		} else {
			LOG.info("This bank already exist in the database");
			throw new BankDoesNotExistsException("This bank already exists in the database");
		}
	}

	@Override
	public BankDetails deleteBankByAcc(Long accno) throws AccountNotFoundException {
		LOG.info("deleteBankByAcc");
		Optional<BankDetails> bank = bankRepository.findById(accno);
		if (bank.isPresent()) {
			bankRepository.deleteById(accno);
			return bank.get();
		} else {
			LOG.info("acc No not avilable");
			throw new AccountNotFoundException(accno + " this Account does not exits.");

		}

	}

}