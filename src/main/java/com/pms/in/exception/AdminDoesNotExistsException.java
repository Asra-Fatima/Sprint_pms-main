package com.pms.in.exception;

public class AdminDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 6294836661695612441L;

	public AdminDoesNotExistsException() {
		super();
	}

	public AdminDoesNotExistsException(String message) {
		super(message);
	}
}
