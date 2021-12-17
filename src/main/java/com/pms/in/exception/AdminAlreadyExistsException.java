package com.pms.in.exception;

public class AdminAlreadyExistsException extends RuntimeException {


	private static final long serialVersionUID = 6294836661695612441L;

	public AdminAlreadyExistsException() {
		super();
	}

	public AdminAlreadyExistsException(String message) {
		super(message);
	}
}