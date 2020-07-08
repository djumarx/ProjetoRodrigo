package br.com.eng3.crud_fornecedor.web.fachada;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Resultado;

public interface IFachada {
	public Resultado salvar(EntidadeDominio entidade);
	public Resultado excluir(EntidadeDominio entidade);
	public Resultado alterar(EntidadeDominio entidade);
	public Resultado consultar(EntidadeDominio entidade);
}
