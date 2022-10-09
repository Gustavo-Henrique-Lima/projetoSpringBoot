package com.gustavonascimento.projetoSpring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id)
	{
		super("Usuário não encontrado. Id "+id);
	}
}
