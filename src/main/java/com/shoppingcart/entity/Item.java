package com.shoppingcart.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "item")
@Data
public class Item {

	@Id
	private String id;
	private String nome;
	private BigDecimal valor;

}
