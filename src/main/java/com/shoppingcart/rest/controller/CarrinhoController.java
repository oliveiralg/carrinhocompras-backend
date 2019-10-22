package com.shoppingcart.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shoppingcart.entity.Carrinho;
import com.shoppingcart.entity.Item;
import com.shoppingcart.entity.Usuario;
import com.shoppingcart.service.CarrinhoService;

@RestController
@RequestMapping(path = "/carrinho")
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;

	@GetMapping(path = "/", produces = "application/json")
	List<Carrinho> getCarrinhos() {
		return carrinhoService.findAll();
	}

	@GetMapping("/{id}")
	Carrinho getCarrinho(@PathVariable String id) {

		return carrinhoService.findById(id);
	}
	
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	ResponseEntity<Object> criarCarrinho(@RequestBody Usuario usuario) {
		carrinhoService.salvar(usuario);
		Carrinho carrinho = carrinhoService.findByUsuario(usuario);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carrinho.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	ResponseEntity<Object> addItem(@RequestBody Item item,@PathVariable String id) {
		Carrinho carrinho = carrinhoService.findById(id);
		carrinhoService.adicionarItem(carrinho, item.getId(), 1);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carrinho.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	void deleteCarrinho(@PathVariable String id) {
		carrinhoService.delete(id);
	}
}
