package br.com.eng3.crud_fornecedor.web.negocio;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;

public class CompletarRanking implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		String ranking = "100";
		
		fornecedor.setRanking(ranking);
		return null;
	}

}
