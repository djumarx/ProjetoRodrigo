package br.com.eng3.crud_fornecedor.dominio;

import java.util.List;

public class Fornecedor extends PessoaJuridica{
	private String ranking;
	private String genero;
	private String dtNascimento;
	private List<Endereco> endereco;
	private Telefone telefone;
	private Usuario usuario;
	private List<Cartao> cartao;
	private List<Produto> produto;

	public Fornecedor(String nome, String cnpj, String ranking, String genero, 
			String dtNascimento, List<Endereco> endereco, Telefone telefone,
			Usuario usuario, List<Cartao> cartao, List<Produto> produto) {
		super(nome, cnpj);
		this.ranking = ranking;
		this.genero = genero;
		this.dtNascimento = dtNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.usuario = usuario;
		this.cartao = cartao;
		this.produto = produto;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Cartao> getCartao() {
		return cartao;
	}

	public void setCartao(List<Cartao> cartao) {
		this.cartao = cartao;
	}
	
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}
