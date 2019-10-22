package com.shoppingcart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.entity.Carrinho;
import com.shoppingcart.entity.Usuario;

public interface CarrinhoRepository extends MongoRepository<Carrinho, String> {

	public Carrinho findByUsuario(Usuario usuario);
}
