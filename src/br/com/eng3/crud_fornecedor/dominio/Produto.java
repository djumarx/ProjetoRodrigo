package br.com.eng3.crud_fornecedor.dominio;

public class Produto extends EntidadeDominio {
	public String nome;
	public double preco;
	public String descricao;
	public String categoria;
	public boolean produtoPadrao;
	
	public Produto (String nome, double preco, String descricao, String categoria, 
			boolean produtoPadrao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.categoria = categoria;
		this.produtoPadrao = produtoPadrao;
	}
	
	public boolean isProdutoPadrao() {
		return produtoPadrao;
	}

	public void setProdutoPadrao(boolean produtoPadrao) {
		this.produtoPadrao = produtoPadrao;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
