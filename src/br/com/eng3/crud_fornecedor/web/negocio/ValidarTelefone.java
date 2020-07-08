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
			st.append("Telefone inválido..." + "\n");
		if(telefone.getDdd().length() < 2)
			st.append("DDD inválido..." + "\n");
		if(telefone.getTipoNumero().trim().equals("") || telefone.getTipoNumero() == null)
			st.append("Tipo de Telefone inválido..." + "\n");
		
		
		return st.toString();
	}

}
