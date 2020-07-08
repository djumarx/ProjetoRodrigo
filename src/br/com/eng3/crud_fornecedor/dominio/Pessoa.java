package br.com.eng3.crud_fornecedor.dominio;

public class Pessoa extends EntidadeDominio {
	public String nome;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
