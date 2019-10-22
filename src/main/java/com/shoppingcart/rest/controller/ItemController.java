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

import com.shoppingcart.entity.Item;
import com.shoppingcart.service.ItemService;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping(path = "/", produces = "application/json")
	List<Item> getItems() {
		return itemService.findAll();
	}

	@GetMapping("/{id}")
	Item getItem(@PathVariable String id) {

		return itemService.findById(id);
	}

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	ResponseEntity<Object> addItem(@RequestBody Item item) {
		itemService.inserir(item);
		item = itemService.findByNome(item.getNome());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	Item replaceItem(@RequestBody Item newItem, @PathVariable String id) {
		return itemService.replaceItem(newItem, id);
	}

	@DeleteMapping("/{id}")
	void deleteItem(@PathVariable String id) {
		itemService.delete(id);
	}
}
