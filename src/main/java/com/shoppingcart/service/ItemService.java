package com.shoppingcart.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.entity.Item;
import com.shoppingcart.exception.ItemNotFoundException;
import com.shoppingcart.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public void salvar(String nome, BigDecimal valor) {
		Item item = new Item();
		item.setNome(nome);
		item.setValor(valor);
		itemRepository.save(item);
	}

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	public long count() {
		return itemRepository.count();
	}

	public Item findById(String id) {
		return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	public void delete(String id) {
		itemRepository.deleteById(id);
	}

	public Item findByNome(String nome) {
		return itemRepository.findByNome(nome);
	}
	
	public void inserir(Item item) {
		itemRepository.save(item);
	}

	public Item replaceItem(Item newItem, String id) {
		return itemRepository.findById(id).map(item -> {
			item.setNome(newItem.getNome());
			item.setValor(newItem.getValor());
			return itemRepository.save(item);
		}).orElseGet(() -> {
			newItem.setId(id);
			return itemRepository.save(newItem);
		});
	}

}
