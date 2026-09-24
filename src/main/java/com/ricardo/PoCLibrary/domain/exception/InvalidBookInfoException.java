package com.ricardo.PoCLibrary.domain.exception;

public class InvalidBookInfoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidBookInfoException(String message) {
		super(message);
	}

}
