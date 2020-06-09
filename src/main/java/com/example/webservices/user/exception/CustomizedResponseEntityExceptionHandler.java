package com.example.webservices.user.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpStatus;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResource exceptionResourse=
				new ExceptionResource(ex.getMessage(),new Date(),request.getDescription(false));
		return new ResponseEntity(exceptionResourse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResource exceptionResourse=
				new ExceptionResource(ex.getMessage(),new Date(),ex.getBindingResult().toString());
		return new ResponseEntity(exceptionResourse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResource exceptionResourse=
				new ExceptionResource(ex.getMessage(),new Date(),request.getDescription(false));
		return new ResponseEntity(exceptionResourse,HttpStatus.NOT_FOUND);
	}

}
