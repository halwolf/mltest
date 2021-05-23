package com.mercadolibre.demoapp.exceptions;

import org.springframework.http.HttpStatus;

public class GeneralException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1565783973343084420L;
	
	private final String message;
	private final HttpStatus status;
	
	public GeneralException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	@Override
	public final String getMessage() {
		return this.message;
	}

	public final HttpStatus getStatus() {
		return status;
	}

}
