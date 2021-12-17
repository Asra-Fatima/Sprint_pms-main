package com.pms.in.exception;

public class PensionerDetailsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PensionerDetailsNotFoundException() {
		super();

	}

	public PensionerDetailsNotFoundException(String message) {
		super(message);

	}
}