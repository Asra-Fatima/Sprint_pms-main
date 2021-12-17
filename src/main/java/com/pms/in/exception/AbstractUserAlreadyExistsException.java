package com.pms.in.exception;

public class AbstractUserAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 6488178516786684248L;

	public AbstractUserAlreadyExistsException() {
		super();
	}

	public AbstractUserAlreadyExistsException(String message) {
		super(message);
	}
}