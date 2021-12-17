package com.pms.in.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pension_details")
public class PensionDetails implements Serializable {

	private static final long serialVersionUID = 1173511369703296438L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pensioners_id;

	@Column
	private Double amount;

	@Column
	private Double charges;

	@Column
	private String bankType;

	@Column
	private int statusCode;

	public PensionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PensionDetails(int pensioners_id, Double amount, Double charges, String bankType, int statusCode) {
		super();
		this.pensioners_id = pensioners_id;
		this.amount = amount;
		this.charges = charges;
		this.bankType = bankType;
		this.statusCode = statusCode;
	}

	public int getPensioner_id() {
		return pensioners_id;
	}

	public void setPensioner_id(int pensioners_id) {
		this.pensioners_id = pensioners_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "PensionDetails [pensioners_id=" + pensioners_id + ", amount=" + amount + ", charges=" + charges
				+ ", bankType=" + bankType + ", statusCode=" + statusCode + "]";
	}

}