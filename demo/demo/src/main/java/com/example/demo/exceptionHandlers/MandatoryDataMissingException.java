package com.example.demo.exceptionHandlers;

import lombok.Data;

@Data
public class MandatoryDataMissingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7792858210701606956L;
	private String message;

	public MandatoryDataMissingException(String message) {
		super();
		this.message = message;
	}
}
