package com.example.VoterDetailed.fetch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EpicNumberNotFoundException.class)
	public ResponseEntity<Object> handleEpicNumberNotFoundException(EpicNumberNotFoundException ex) {
		String responseBody = "{\"error\":" + "{\"statusCode\":404," + "\"name\":\"error\"," + "\"message\":\""
				+ ex.getMessage() + "\"," + "\"status\":404" + "}}";
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
	}

	@ExceptionHandler(EmptyEpicNumberException.class)
	public ResponseEntity<Object> handleEmptyEpicNumberException(EmptyEpicNumberException ex) {
		String responseBody = "{\"error\":" + "{\"statusCode\":400," + "\"name\":\"error\"," + "\"message\":\""
				+ ex.getMessage() + "\"," + "\"reason\": \"VALIDATION_ERROR\"," + "\"status\":400" + "}}";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
	}

	@ExceptionHandler(InvalidGetAdditionalDataException.class)
	public ResponseEntity<Object> handleInvalidGetAdditionalDataException(InvalidGetAdditionalDataException ex) {
		String errorMessage = ex.getMessage();
		String responseBody;
		if (errorMessage.equals("getAdditionalData can only be 'true' or 'false'")) {
			responseBody = "{\"error\":" + "{\"statusCode\":400," + "\"name\":\"error\"," + "\"message\":\""
					+ errorMessage + "\"," + "\"reason\": \"VALIDATION_ERROR\"," + "\"status\":400" + "}}";
		} else {
			responseBody = "{\"error\":" + "{\"statusCode\":400," + "\"name\":\"error\"," + "\"message\":\""
					+ errorMessage + "\"," + "\"status\":400" + "}}";
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
	}

}
