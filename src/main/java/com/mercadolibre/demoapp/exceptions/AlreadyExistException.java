package com.mercadolibre.demoapp.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistException extends GeneralException{
	
	private static final long serialVersionUID = 4961291826177451208L;
	
	public AlreadyExistException(String message) {
		super(message,  HttpStatus.ALREADY_REPORTED);
	}

}
