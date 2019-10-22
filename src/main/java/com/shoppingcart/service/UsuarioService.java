package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.entity.Usuario;
import com.shoppingcart.exception.UsuarioNotFoundException;
import com.shoppingcart.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void salvar(String nome, String email) {
		Usuario Usuario = new Usuario();
		Usuario.setNome(nome);
		Usuario.setEmail(email);
		usuarioRepository.save(Usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public long count() {
		return usuarioRepository.count();
	}

	public Usuario findById(String id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
	}

	public void delete(String id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario findByNome(String nome) {
		return usuarioRepository.findByNome(nome);
	}

	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public void inserir(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public Usuario replaceUsuario(Usuario newUsuario, String id) {
		return usuarioRepository.findById(id).map(usuario -> {
			usuario.setNome(newUsuario.getNome());
			usuario.setEmail(newUsuario.getEmail());
			return usuarioRepository.save(usuario);
		}).orElseGet(() -> {
			newUsuario.setId(id);
			return usuarioRepository.save(newUsuario);
		});
	}
}
