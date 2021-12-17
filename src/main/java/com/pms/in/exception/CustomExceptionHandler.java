package com.pms.in.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(PensionerDetailsNotFoundException.class)
	public ResponseEntity<Object> handlePensionerDetailsNotFoundException() {
		LOG.error("handlePensionerNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Invalid pensioner detail provided, please provide valid detail..");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PensionerAlreadyExistsException.class)
	public ResponseEntity<Object> handlePensionerAlreadyExistsException() {
		LOG.error("handlePensionerAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Pensioner Already Exits");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BankNotAddedException.class)
	public ResponseEntity<Object> handleBankNotAddedException() {
		LOG.error("handleBankAlreadyAddedException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Bank is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PensionDetailsNotFoundException.class)
	public ResponseEntity<Object> handlePensionDetailsNotFoundException() {
		LOG.error("handlePensionDetailsNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This pension details is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PensionDetailsAlreadyExsitsException.class)
	public ResponseEntity<Object> handlePensionDetailsAlreadyExsitsException() {
		LOG.error("handlePensionDetailsAlreadyExsitsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This pension details is already exsits in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AbstractUserNotFoundException.class)
	public ResponseEntity<Object> handleAbstractUserNotFoundException() {
		LOG.error("handleAbstractUserNotFound");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This user is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AbstractUserAlreadyExistsException.class)
	public ResponseEntity<Object> handleAbstractUserAlreadyExistsException() {
		LOG.error("handleAbstractUserAlreadyExists");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This user is already available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BankAlreadyExistsException.class)
	public ResponseEntity<Object> handleBankAlreadyExistsException() {
		LOG.error("handleBankAlreadyExists");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Bank is already exists in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BankDoesNotExistsException.class)
	public ResponseEntity<Object> handleBankDoesNotExistsException() {
		LOG.error("handleBankDoesNotExists");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Bank does not exists in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IncorrectLoginCredentialsException.class)
	public ResponseEntity<Object> handleIncorrectLoginCredentialsException() {
		LOG.error("handleIncorrectLoginCredentials");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Please enter correct data ");
		return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminDoesNotExistsException.class)
	public ResponseEntity<Object> handleAdminDoesNotExistsException() {
		LOG.error("handleAdminDoesNotExists");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This admin is not logged in.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AdminAlreadyExistsException.class)
	public ResponseEntity<Object> handleAdminAlreadyExistsException() {
		LOG.error("handleAdminDoesNotExists");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This admin is already available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> handleAccountNotFoundException() {
		LOG.error("handleAccountNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Bank Account Not avilable.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}
	
	

}
