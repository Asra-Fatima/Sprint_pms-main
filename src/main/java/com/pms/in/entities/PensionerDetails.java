package com.pms.in.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pensioner_details")
public class PensionerDetails implements Serializable {

	private static final long serialVersionUID = -6741695700708873345L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pensioner_id;

	@Column
	private int age;

	@Column
	private int aadhar;

	@Column
	private int pan;

	@Column
	private int salary;

	@Column
	private long acc_No;

	@Column
	private String pensionType;

	@OneToOne
	@JoinColumn(name = "pensioners_id")
	private PensionDetails pensionDetails;

	@OneToOne
	@JoinColumn(name = "accno")
	private BankDetails bankDetails;

	public PensionerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PensionerDetails(int pensioner_id, int age, int aadhar, int pan, int salary, int acc_No,
			String pensionType) {
		super();
		this.pensioner_id = pensioner_id;
		this.age = age;
		this.aadhar = aadhar;
		this.pan = pan;
		this.salary = salary;
		this.acc_No = acc_No;
		this.pensionType = pensionType;
	}

	public PensionerDetails(int pensioner_id, int age, int aadhar, int pan, int salary, int acc_No, String pensionType,
			PensionDetails pensionDetails) {
		super();
		this.pensioner_id = pensioner_id;
		this.age = age;
		this.aadhar = aadhar;
		this.pan = pan;
		this.salary = salary;
		this.acc_No = acc_No;
		this.pensionType = pensionType;
		this.pensionDetails = pensionDetails;
	}

	public PensionerDetails(int pensioner_id, int age, int aadhar, int pan, int salary, int acc_No, String pensionType,
			PensionDetails pensionDetails, BankDetails bankDetails) {
		super();
		this.pensioner_id = pensioner_id;
		this.age = age;
		this.aadhar = aadhar;
		this.pan = pan;
		this.salary = salary;
		this.acc_No = acc_No;
		this.pensionType = pensionType;
		this.pensionDetails = pensionDetails;
		this.bankDetails = bankDetails;
	}

	public int getPensioner_id() {
		return pensioner_id;
	}

	public void setPensioner_id(int pensioner_id) {
		this.pensioner_id = pensioner_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAadhar() {
		return aadhar;
	}

	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}

	public int getPan() {
		return pan;
	}

	public void setPan(int pan) {
		this.pan = pan;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public long getAcc_No() {
		return acc_No;
	}

	public void setAcc_No(int acc_No) {
		this.acc_No = acc_No;
	}

	public String getPensionType() {
		return pensionType;
	}

	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}

	public PensionDetails getPensionDetails() {
		return pensionDetails;
	}

	public void setPensionDetails(PensionDetails pensionDetails) {
		this.pensionDetails = pensionDetails;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Override
	public String toString() {
		return "PensionerDetails [pensioner_id=" + pensioner_id + ", age=" + age + ", aadhar=" + aadhar + ", pan=" + pan
				+ ", salary=" + salary + ", acc_No=" + acc_No + ", pensionType=" + pensionType + ", pensionDetails="
				+ pensionDetails + ", bankDetails=" + bankDetails + "]";
	}

}