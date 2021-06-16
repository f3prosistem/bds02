package com.devsuperior.bds02.service.exceptions;

public class DatabaseExeption extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public DatabaseExeption(String msg) {
		super(msg);
	}

}
