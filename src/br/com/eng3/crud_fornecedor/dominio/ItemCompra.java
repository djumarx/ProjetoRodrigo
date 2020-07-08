package br.com.eng3.crud_fornecedor.dominio;

public class ItemCompra extends EntidadeDominio {
	private int quantidade;
	
	public ItemCompra(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
