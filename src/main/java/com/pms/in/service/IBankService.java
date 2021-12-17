package com.pms.in.service;

import com.pms.in.entities.BankDetails;
import com.pms.in.exception.AccountNotFoundException;

public interface IBankService
{
	public BankDetails addBank(BankDetails bankDetails);
	public BankDetails deleteBankByAcc(Long accno) throws AccountNotFoundException;
}