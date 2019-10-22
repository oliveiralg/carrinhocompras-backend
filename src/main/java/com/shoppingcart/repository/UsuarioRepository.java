package com.shoppingcart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	public Usuario findByNome(String nome);
	public Usuario findByEmail(String email);
}
