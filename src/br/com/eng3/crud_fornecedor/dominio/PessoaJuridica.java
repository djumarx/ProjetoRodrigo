package br.com.eng3.crud_fornecedor.dominio;

public class PessoaJuridica extends Pessoa{
	public String cnpj;
	
	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
