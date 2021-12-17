package com.pms.in.exception;

public class IncorrectLoginCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 6294836661695612441L;

	public IncorrectLoginCredentialsException() {
		super();
	}

	public IncorrectLoginCredentialsException(String message) {
		super(message);
	}
}