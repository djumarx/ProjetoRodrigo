package br.com.eng3.crud_fornecedor.command;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Resultado;

public class ExcluirCommand extends AbstractCommand{

	@Override
	public Resultado executar(EntidadeDominio entidade) {
		return fachada.excluir(entidade);
	}

}
