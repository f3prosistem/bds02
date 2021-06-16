package com.devsuperior.bds02.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.devsuperior.bds02.service.exceptions.DatabaseExeption;
import com.devsuperior.bds02.service.exceptions.ResourceNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExeption.class)
	public ResponseEntity<StanderdError> entityNotFound(ResourceNotFoundExeption e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StanderdError err = new StanderdError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Recurso não encontrado");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}

	@ExceptionHandler(DatabaseExeption.class)
	public ResponseEntity<StanderdError> database(DatabaseExeption e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StanderdError err = new StanderdError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Exceção de banco de dados");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
