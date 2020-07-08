package br.com.eng3.crud_fornecedor.web.negocio;

import java.util.List;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Produto;

public class ValidarProdutoPadrao implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		List<Produto> produtos = fornecedor.getProduto();
		int count = 0;
		
		boolean produtoPadrao = true;
		
		for(Produto prod : produtos) {
			if(prod.isProdutoPadrao()) {
				produtoPadrao = true;
				count += 1;
			}
		}
		if(count > 1) {
			return "Não é possivel cadastrar mais de um produto padrão...\n";
		}else {
			return null;
		}
	}

}
