package br.com.eng3.crud_fornecedor.web.negocio;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Usuario;

public class ValidarSenha implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof Fornecedor) {
			Fornecedor fornecedor = (Fornecedor) entidade;
			return (fornecedor.getUsuario().getSenha().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,50})"))
					? null : "Senha inválida, deve conter pelo menos 8 caracteres incluindo letras maiusculas, minusculas e sinais\n";
		}
		else {
			Usuario usuario = (Usuario)entidade;
			return (usuario.getSenha().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,50})"))
					? null : "Senha inválida, deve conter pelo menos 8 caracteres incluindo letras maiusculas, minusculas e sinais\n";
		
		}
	}

}
