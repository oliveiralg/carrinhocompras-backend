package com.shoppingcart.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shoppingcart.entity.Usuario;
import com.shoppingcart.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(path = "/", produces = "application/json")
	List<Usuario> getUsuarios() {
		return usuarioService.findAll();
	}

	@GetMapping("/{id}")
	Usuario getUsuario(@PathVariable String id) {

		return usuarioService.findById(id);
	}

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	ResponseEntity<Object> addUsuario(@RequestBody Usuario usuario) {
		usuarioService.inserir(usuario);
		usuario = usuarioService.findByEmail(usuario.getEmail());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable String id) {
		return usuarioService.replaceUsuario(newUsuario, id);
	}

	@DeleteMapping("/{id}")
	void deleteUsuario(@PathVariable String id) {
		usuarioService.delete(id);
	}
}
