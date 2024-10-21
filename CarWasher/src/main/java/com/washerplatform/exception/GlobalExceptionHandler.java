package com.washerplatform.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(WasherAlreadyExists.class)
	public ResponseEntity<String> handleWasherAlreadyExists(WasherAlreadyExists exp){
		return new ResponseEntity<>("OOps:): "+exp.getMessage(),HttpStatus.ALREADY_REPORTED);
	}
	@ExceptionHandler(WasherIdNotFound.class)
	public ResponseEntity<String> handleWasherIdNotFound(WasherIdNotFound exp){
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
 
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
 
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
