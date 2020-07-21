package com.ricardoronsoni.curso.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	//a diferença dessa funcao é que recebe a causa do problema
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
