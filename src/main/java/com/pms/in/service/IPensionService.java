package com.pms.in.service;

import com.pms.in.entities.PensionDetails;

public interface IPensionService
{
	public PensionDetails addPensionDetails(PensionDetails pensionDetails);
	public PensionDetails updatePensionDetails(PensionDetails pensionDetails);
	public PensionDetails viewPensionDetails(int pensionerId);
}