package com.verification.verification_service.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleException(CustomException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleCommomException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
	}
}
