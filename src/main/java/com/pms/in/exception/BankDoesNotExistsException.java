package com.pms.in.exception;


public class BankDoesNotExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 6488178516786684248L;

	public BankDoesNotExistsException() {
		super();
	}

	public BankDoesNotExistsException(String message) {
		super(message);
	}

}