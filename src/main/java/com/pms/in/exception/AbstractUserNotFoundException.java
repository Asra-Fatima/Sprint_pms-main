package com.pms.in.exception;

public class AbstractUserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 6294836661695612441L;

	public AbstractUserNotFoundException() {
		super();
	}

	public AbstractUserNotFoundException(String message) {
		super(message);
	}
}
