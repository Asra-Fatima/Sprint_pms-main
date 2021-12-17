package com.pms.in.exception;

public class BankAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 6488178516786684248L;

	public BankAlreadyExistsException() {
		super();
	}

	public BankAlreadyExistsException(String message) {
		super(message);
	}
}
