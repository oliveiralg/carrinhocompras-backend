package com.shoppingcart.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "carrinho")
@Data
public class Carrinho {

	@Id
	private String id;
	@DBRef
	private Usuario usuario;
	private Map<String, Integer> items;

}
