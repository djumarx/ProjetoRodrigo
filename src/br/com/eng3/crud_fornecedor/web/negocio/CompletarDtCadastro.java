package br.com.eng3.crud_fornecedor.web.negocio;

import java.util.Date;
import java.text.SimpleDateFormat;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;

public class CompletarDtCadastro implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
		String data = formatDate.format(new Date());
		
		entidade.setDtCadstro(data);
		
		return null;
	}

}
