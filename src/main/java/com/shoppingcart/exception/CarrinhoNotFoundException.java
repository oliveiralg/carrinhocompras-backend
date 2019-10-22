package com.shoppingcart.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarrinhoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -903959873379356929L;

	public CarrinhoNotFoundException(String id) {
		super("Carrinho não encontrado. Id = " + id);
		log.info("Carrinho não encontrado. Id = " + id);
	}

}
