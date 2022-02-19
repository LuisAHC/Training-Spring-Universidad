package com.ibm.academia.apirest.excepciones;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String mensaje)
	{
		super(mensaje);
	}
}