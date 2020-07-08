package br.com.eng3.crud_fornecedor.dao;

import java.util.List;
import br.com.eng3.crud_fornecedor.dominio.*;

public interface IDAO {
	public void salvar(EntidadeDominio entidade);
	public void alterar(EntidadeDominio entidade);
	public void excluir(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
}
