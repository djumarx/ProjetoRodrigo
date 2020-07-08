package br.com.eng3.crud_fornecedor.web.negocio;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Telefone;

public class ValidarTelefone implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		Telefone telefone = fornecedor.getTelefone();
		
		StringBuilder st = new StringBuilder();
		
		if(telefone.getNumero().length() < 8)
			st.append("Telefone inv�lido..." + "\n");
		if(telefone.getDdd().length() < 2)
			st.append("DDD inv�lido..." + "\n");
		if(telefone.getTipoNumero().trim().equals("") || telefone.getTipoNumero() == null)
			st.append("Tipo de Telefone inv�lido..." + "\n");
		
		
		return st.toString();
	}

}
