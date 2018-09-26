/**
 * 
 */
package com.learning.rest.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.rest.modal.ExceptionResponseBean;

/**
 * @author alexsurya
 *
 */
@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity(exceptionResponseBean, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request) {
		ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity(exceptionResponseBean, HttpStatus.NOT_FOUND);

	}

	@Override
	protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus httpStatus, WebRequest request) {
		ExceptionResponseBean exceptionResponseBean = new ExceptionResponseBean(new Date(), "Validation failed",
				ex.getBindingResult().getAllErrors().toString());

		return new ResponseEntity(exceptionResponseBean, HttpStatus.BAD_REQUEST);

	}
}
