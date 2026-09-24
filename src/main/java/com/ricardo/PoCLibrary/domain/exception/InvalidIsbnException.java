package com.ricardo.PoCLibrary.domain.exception;

public class InvalidIsbnException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidIsbnException(String message) {
		super(message);
	}

}
