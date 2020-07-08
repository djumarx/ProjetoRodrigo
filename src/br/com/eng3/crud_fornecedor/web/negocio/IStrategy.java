package br.com.eng3.crud_fornecedor.web.negocio;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade);
}
