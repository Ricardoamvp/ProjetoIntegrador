package com.ecommerce.lifeshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ecommerce.lifeshop.model.util.Categoria;



@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Erro nome produto não pode estar em branco")
	@Size(min = 2, max = 45, message = "Erro tamanho nome")
	private String nome;
	
	@NotBlank(message = "Erro descrição produto não pode estar em branco")
	@Size(min = 5, max = 255, message = "Erro tamanho descricao")
	private String descricao;

	@NotNull(message = "Erro preço não deve estar nulo")
	private Float preco;
	
	@NotNull(message = "Erro estoque não deve estar nulo")
	private Integer estoque;
	
	@NotBlank(message = "Imagem não pode estar em branco")
	private String urlProduto;
	 
	 
	private @Enumerated(EnumType.STRING) Categoria categoria;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<Item> venda = new ArrayList<>();
	

	//URL Produto
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	
	//Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	//Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	//Descricao
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	//Preco
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	
	//Estoque
	public int getEstoque() {
		return estoque;
	}
	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
	//Para relacionamento com o enum categoria
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	/*
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
*/
	
}