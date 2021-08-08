package com.ajtutorial.deptservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleEmptyInput(Exception e){
		return new ResponseEntity<String>("Exception Occured", HttpStatus.BAD_REQUEST);
	}
}
