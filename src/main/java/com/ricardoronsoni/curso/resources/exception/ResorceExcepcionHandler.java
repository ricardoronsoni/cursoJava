package com.ricardoronsoni.curso.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ricardoronsoni.curso.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResorceExcepcionHandler {
	
	//essa é a assinatura padrao do @ControllerAdvice
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		//o HttpStatus.NOT_FOUND.value() é para retornar o codigo 404
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
