package com.ibm.academia.apirest.excepciones;

public class BadRequestException extends RuntimeException {
	public BadRequestException(String mensaje)
	{
		super(mensaje);
	}
}