package com.shoppingcart.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2688549168014732269L;

	public ItemNotFoundException(String id) {
		super("Item não encontrado. Id = " + id);
		log.info("Item não encontrado. Id = " + id);
	}

}
