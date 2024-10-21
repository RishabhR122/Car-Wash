package com.customer.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerDoNotExistException extends RuntimeException {

	public CustomerDoNotExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDoNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomerDoNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerDoNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerDoNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
