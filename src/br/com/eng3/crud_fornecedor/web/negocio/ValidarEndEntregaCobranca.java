package br.com.eng3.crud_fornecedor.web.negocio;

import java.util.List;

import br.com.eng3.crud_fornecedor.dominio.Endereco;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;

public class ValidarEndEntregaCobranca implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		List<Endereco> enderecos = fornecedor.getEndereco();
		
		boolean entrega = false;
		boolean cobranca = false;
		
		for(Endereco end : enderecos) {
			if(end.isCobranca()) {
				cobranca = true;
			}
			if(end.isEntrega()) {
				entrega = true;
			}
		}
		
		if(!entrega || !cobranca) {
			return "Sem endereço de Entrega e/ou Cobrança...\n";
		}else {
			return null;
		}
	}
}