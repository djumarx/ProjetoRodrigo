package br.com.eng3.crud_fornecedor.web.negocio;

import java.util.List;

import br.com.eng3.crud_fornecedor.dao.DAOFornecedor;
import br.com.eng3.crud_fornecedor.dao.IDAO;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Usuario;

public class ValidarExistencia implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		String msg = "";
		Fornecedor fornecedorExisteCnpj = new Fornecedor("", fornecedor.getCnpj(), "","","", null, null, null, null, null);
		IDAO daoFornecedor = new DAOFornecedor();
		
		List<EntidadeDominio> listaFornecedoresCnpj = daoFornecedor.consultar(fornecedorExisteCnpj);
		
		if(listaFornecedoresCnpj.size() != 0) {
			msg = "CNPJ já cadastrado";
		}
		Fornecedor listaFornecedorExistenteLogin = new Fornecedor("", "", "", "", "", null, null, new Usuario(fornecedor.getUsuario().getEmail(),"", false, false), null, null);
		listaFornecedoresCnpj = daoFornecedor.consultar(listaFornecedorExistenteLogin);
		
		if (listaFornecedoresCnpj.size() != 0)
			msg += "Login Já Cadastrado...\n";
		return msg;
	}
}