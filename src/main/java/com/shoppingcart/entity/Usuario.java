package com.shoppingcart.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "usuario")
@Data
public class Usuario {

	@Id
	private String id;
	private String nome;
	private String email;

}
