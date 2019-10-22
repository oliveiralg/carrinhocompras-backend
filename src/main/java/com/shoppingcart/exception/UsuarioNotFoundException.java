package com.shoppingcart.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsuarioNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7304201076086122656L;

	public UsuarioNotFoundException(String id) {
		super("Usuário não encontrado. Id = " + id);
		log.info("Usuário não encontrado. Id = " + id);
	}

}
