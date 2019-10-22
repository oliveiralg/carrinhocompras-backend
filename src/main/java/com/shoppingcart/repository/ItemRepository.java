package com.shoppingcart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.entity.Item;

public interface ItemRepository extends MongoRepository<Item, String> {

	public Item findByNome(String nome);
}
