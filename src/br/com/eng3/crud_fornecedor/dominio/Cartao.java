package br.com.eng3.crud_fornecedor.dominio;

public class Cartao extends EntidadeDominio {
	private String nome;
	private String numero;
	private String codSeguranca;
	private Bandeira bandeira;
	
	public Cartao(String nome, String numero, String codSeguranca, Bandeira bandeira) {
		this.nome = nome;
		this.numero = numero;
		this.codSeguranca = codSeguranca;
		this.bandeira = bandeira;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodSeguranca() {
		return codSeguranca;
	}
	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
	
}
