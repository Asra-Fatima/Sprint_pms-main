package com.pms.in.exception;

public class AccountNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 6488178516786684248L;

	public AccountNotFoundException() {
		super();
	}

	public AccountNotFoundException(String message) {
		super(message);
	}
}