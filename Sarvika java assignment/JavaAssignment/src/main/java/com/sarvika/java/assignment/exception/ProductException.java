package com.sarvika.java.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public ProductException(String message) {
		super(HttpStatus.BAD_REQUEST, message);
	}

	public ProductException(HttpStatus status, String message) {
		super(status, message);
	}

	public static ProductException notFound(Long id) {
		return new ProductException(HttpStatus.NOT_FOUND, "Product with ID " + id + " not found");
	}

	public static ProductException invalidInput(String msg) {
		return new ProductException(HttpStatus.BAD_REQUEST, msg);
	}

	public static ProductException serverError(String msg) {
		return new ProductException(HttpStatus.INTERNAL_SERVER_ERROR, msg);
	}

}
