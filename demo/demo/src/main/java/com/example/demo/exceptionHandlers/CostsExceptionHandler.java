package com.example.demo.exceptionHandlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CostsExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorMessage> handleConflict(Exception ex) {
		String errorMessage=ex.getLocalizedMessage();
		if (errorMessage==null)
			errorMessage=ex.getMessage();
		ErrorMessage exceptionResponse = new ErrorMessage(errorMessage, "Neka greška");
		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MandatoryDataMissingException.class)
	protected ResponseEntity<ErrorMessage> handleMissingData(MandatoryDataMissingException ex) {
		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "Data missing");
		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}

class ErrorMessage {
	private String message;
	private String detail;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	ErrorMessage(String message, String detail) {
		super();
		this.message = message;
		this.detail = detail;
	}

}