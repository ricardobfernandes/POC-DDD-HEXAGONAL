package com.ricardo.PoCLibrary.adapter.in.web.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ricardo.PoCLibrary.domain.exception.BookNotFoundException;
import com.ricardo.PoCLibrary.domain.exception.InvalidBookInfoException;
import com.ricardo.PoCLibrary.domain.exception.InvalidIsbnException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<StandardError> bookNotFound(BookNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), "Book not found", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler({ InvalidBookInfoException.class, InvalidIsbnException.class })
	public ResponseEntity<StandardError> badRequestException(RuntimeException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), "Bad Request", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
