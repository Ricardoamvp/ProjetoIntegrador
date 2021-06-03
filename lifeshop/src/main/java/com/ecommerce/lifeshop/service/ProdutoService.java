package com.ecommerce.lifeshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.ecommerce.lifeshop.model.Produto;
import com.ecommerce.lifeshop.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService { 
	
	@Autowired
	private ProdutoRepository repository;

	//trazer todos
	public ResponseEntity<List<Produto>> findAllProduto(){
		List<Produto> produtos = repository.findAll();
		if(produtos.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(produtos);
		}
	}
	//trazer por id
	public ResponseEntity<Produto> findProdutoById(Long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(404).build());
	}

	//salvar categoria
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	//deletar por id
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	 //trazer por descricao
	public ResponseEntity<List<Produto>> findProdutoByDescricao(String descricao){
		List<Produto> produtos = repository.findAllByDescricaoContainingIgnoreCase(descricao);
		if(!produtos.isEmpty()) {
			return ResponseEntity.status(302).body(produtos);
		} else {
		return ResponseEntity.status(204).build();
		}
	}
	
	
}
