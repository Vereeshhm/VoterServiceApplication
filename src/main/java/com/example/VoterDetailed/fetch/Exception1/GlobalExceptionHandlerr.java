package com.example.VoterDetailed.fetch.Exception1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandlerr {

	
	@ExceptionHandler(EmptyEpicnumberException.class)
	public ResponseEntity<Object> handleEmptyEpicNumberException(EmptyEpicnumberException ex) {
		String responseBody = "{\"error\":{" +
                "\"name\":\"error\"," +
                "\"message\":\"" + ex.getMessage() + "\"," +
                "\"status\":400," +
                "\"reason\":\"VALIDATION_ERROR\"," +
                "\"type\":\"Bad Request\"," +
                "\"statusCode\":400" +
                "}}";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
	}
	
	@ExceptionHandler(InvalidEpicException.class)
	public ResponseEntity<Object>handleInvalidEpicException(InvalidEpicException ex)
	{
		String responseBody = "{\"error\":{" +
                "\"name\":\"error\"," +
                "\"message\":\"" + ex.getMessage() + "\"," +
                "\"status\":400," +
                "\"reason\":\"Invalid_Param\"," +
                "\"type\":\"Bad Request\"," +
                "\"statusCode\":400" +
                "}}";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
	}
	
	@ExceptionHandler(EpicnumberNotfoundException.class)
	public ResponseEntity<Object>handleEpicnumberNotfoundException(EpicnumberNotfoundException ex)
	{
		String responseBody = "{\"error\":{" +
                "\"name\":\"error\"," +
                "\"message\":\"" + ex.getMessage() + "\"," +
                "\"status\":404," +
                "\"reason\":\"NOT_FOUND\"," +
                "\"type\":\"Not Found\"," +
                "\"statusCode\":404" +
                "}}";
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
	}
}
