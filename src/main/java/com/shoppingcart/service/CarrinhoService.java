package com.shoppingcart.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.entity.Carrinho;
import com.shoppingcart.entity.Usuario;
import com.shoppingcart.exception.CarrinhoNotFoundException;
import com.shoppingcart.repository.CarrinhoRepository;

@Service
public class CarrinhoService {
	@Autowired
	private CarrinhoRepository carrinhoRepository;

	public void salvar(Usuario usuario) {
		Carrinho carrinho = new Carrinho();
		carrinho.setUsuario(usuario);
		carrinho.setItems(new ConcurrentHashMap<String, Integer>());
		carrinhoRepository.save(carrinho);
	}

	public void adicionarItem(Carrinho carrinho, String itemId, Integer qtde) {
		Map<String, Integer> items = carrinho.getItems();
		// Verifica se o item já está no carrinho
		items.computeIfPresent(itemId, (key, value) -> { return value + qtde; });
		items.putIfAbsent(itemId, qtde);
		carrinho.setItems(items);

		carrinhoRepository.save(carrinho);
	}

	public List<Carrinho> findAll() {
		return carrinhoRepository.findAll();
	}

	public long count() {
		return carrinhoRepository.count();
	}

	public Carrinho findById(String id) {
		return carrinhoRepository.findById(id).orElseThrow(() -> new CarrinhoNotFoundException(id));
	}

	public void delete(String id) {
		carrinhoRepository.deleteById(id);
	}

	public Carrinho findByUsuario(Usuario usuario) {
		return carrinhoRepository.findByUsuario(usuario);
	}

}
