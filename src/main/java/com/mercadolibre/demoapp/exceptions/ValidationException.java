package com.mercadolibre.demoapp.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationException extends GeneralException{
	
	private static final long serialVersionUID = 4961291826177451208L;
	
	public ValidationException(String message) {
		super(message,  HttpStatus.NOT_ACCEPTABLE);
	}

}
