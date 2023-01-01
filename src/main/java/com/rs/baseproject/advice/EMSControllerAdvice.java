package com.rs.baseproject.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rs.baseproject.constant.GlobalConstants_Exception;
import com.rs.baseproject.custom.exception.EmptyFieldException;
import com.rs.baseproject.custom.exception.NoRecordFoundException;
import com.rs.baseproject.custom.exception.NoRecordFoundForGivenIdException;

@RestControllerAdvice
public class EMSControllerAdvice {

	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<String> handleEmptyField(EmptyFieldException emptyFieldException) {
		return new ResponseEntity<String>(GlobalConstants_Exception.INPUT_FIELD_IS_EMPTY, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<String> handleNoRecordFound(NoRecordFoundException noRecordFoundException) {
		return new ResponseEntity<String>(GlobalConstants_Exception.NO_RECORD_FOUND, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoRecordFoundForGivenIdException.class)
	public ResponseEntity<String> handleNoRecordFoundForGivenId(
			NoRecordFoundForGivenIdException noRecordFoundException) {
		return new ResponseEntity<String>(
				GlobalConstants_Exception.NO_RECORD_FOUND_FOR_GIVEN_ID + noRecordFoundException.getEmployeeId(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		Map<String, String> response = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
		return new ResponseEntity<String>(GlobalConstants_Exception.METHOD_REQUEST_NOT_SUPPORTED, HttpStatus.NOT_FOUND);
	}

}
