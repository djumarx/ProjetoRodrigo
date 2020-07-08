package br.com.eng3.crud_fornecedor.dominio;

public class Compra extends EntidadeDominio {
	private String status;
	private String dtCompra;
	
	public Compra(String status, String dtCompra) {
		this.status = status;
		this.dtCompra = dtCompra;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDtCompra() {
		return dtCompra;
	}
	public void setDtCompra(String dtCompra) {
		this.dtCompra = dtCompra;
	}
	
}
