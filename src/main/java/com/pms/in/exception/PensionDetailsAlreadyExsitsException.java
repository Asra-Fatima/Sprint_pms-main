package com.pms.in.exception;

public class PensionDetailsAlreadyExsitsException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public PensionDetailsAlreadyExsitsException() {
		super();

	}

	public PensionDetailsAlreadyExsitsException(String message) {
		super(message);

	}
}
