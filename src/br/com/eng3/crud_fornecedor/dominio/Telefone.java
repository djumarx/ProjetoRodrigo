package br.com.eng3.crud_fornecedor.dominio;

public class Telefone extends EntidadeDominio {
	private String tipoNumero;
	private String ddd;
	private String numero;
	
	public Telefone(String tipoNumero, String ddd, String numero) {
		this.tipoNumero = tipoNumero;
		this.ddd = ddd;
		this.numero = numero;
	}
	public String getTipoNumero() {
		return tipoNumero;
	}
	public void setTipoNumero(String tipoNumero) {
		this.tipoNumero = tipoNumero;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
