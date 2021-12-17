package com.pms.in.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_details")
public class BankDetails {

	@Id
	private Long accno;

	@Column(nullable = false)
	private String bankName;

	@Column
	private String branch;

	@Column
	private String ifscCode;

	@Column(nullable = false)
	private String AccHolderName;

	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankDetails(Long accno, String bankName, String branch, String ifscCode, String accHolderName) {
		super();
		this.accno = accno;
		this.bankName = bankName;
		this.branch = branch;
		this.ifscCode = ifscCode;
		AccHolderName = accHolderName;
	}

	public Long getAccno() {
		return accno;
	}

	public void setAccno(Long accno) {
		this.accno = accno;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccHolderName() {
		return AccHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		AccHolderName = accHolderName;
	}

	@Override
	public String toString() {
		return "BankDetails [accno=" + accno + ", bankName=" + bankName + ", branch=" + branch + ", ifscCode="
				+ ifscCode + ", AccHolderName=" + AccHolderName + "]";
	}

}