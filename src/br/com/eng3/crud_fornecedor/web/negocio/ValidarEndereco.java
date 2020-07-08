package br.com.eng3.crud_fornecedor.web.negocio;

import br.com.eng3.crud_fornecedor.dominio.Endereco;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;

public class ValidarEndereco implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco end = (Endereco) entidade;
		boolean cobranca = false, entrega = false;
		StringBuilder msg = new StringBuilder();
		msg.setLength(0);
		
			if (end.isCobranca())
				cobranca = true;
			if (end.isEntrega())
				entrega = true;
			
			if(end.getTipoResidencia() == null || end.getTipoResidencia().trim().equals("")) 
				msg.append("Tipo de Residencia inválido" + "\n");
			
			if(end.getTipoLogradouro() == null || end.getTipoLogradouro().trim().equals("")) 
				msg.append("Tipo de Logradouro inválido" + "\n");
			
			if(end.getNome() == null || end.getNome().trim().equals("")) 
				msg.append("Todos os endereços precisam de um nome!" + "\n");
			
			if(end.getLogradouro() == null || end.getLogradouro().trim().equals("")) 
				msg.append("Logradouro inválido" + "\n");
			
			if(end.getNumero() == null || end.getNumero().trim().equals("")) 
				msg.append("Numero de Residencia inválido" + "\n");
			
			if(end.getBairro() == null || end.getBairro().trim().equals("")) 
				msg.append("Bairro inválido" + "\n");
			
			if(end.getCep() == null || end.getCep().trim().equals("")) 
				msg.append("CEP inválido" + "\n");
			
			if(end.getCidade() == null || end.getCidade().trim().equals("")) 
				msg.append("Cidade inválida" + "\n");
			
			if(end.getEstado() == null || end.getEstado().trim().equals("")) 
				msg.append("Estado inválido" + "\n");
			
			if(end.getPais() == null || end.getPais().trim().equals("")) 
				msg.append("Pais inválido" + "\n");
			
		return msg.toString();
	}
}
