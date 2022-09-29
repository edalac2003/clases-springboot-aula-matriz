package com.curso.spring.sales.service.exceptions;

public class AmountOfProductNotAvailableException extends Exception {

	public AmountOfProductNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public AmountOfProductNotAvailableException(String message) {
		super(message);
	}

	
}
