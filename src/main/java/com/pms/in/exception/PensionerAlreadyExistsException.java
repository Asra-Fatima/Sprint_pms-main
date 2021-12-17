package com.pms.in.exception;



public class PensionerAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 6488178516786684248L;

	public PensionerAlreadyExistsException() {
		super();
	}

	public PensionerAlreadyExistsException(String message) {
		super(message);
	}

}