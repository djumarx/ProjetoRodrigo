package br.com.eng3.crud_fornecedor.dominio;

public class Bandeira extends EntidadeDominio {
	public String nome;
	
	public Bandeira(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
