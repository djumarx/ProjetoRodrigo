package br.com.eng3.crud_fornecedor.web.negocio;

import java.util.ArrayList;

import br.com.eng3.crud_fornecedor.dominio.Cartao;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;

public class ValidarBandeira implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		ArrayList<String> bandeiras = new ArrayList();
		Cartao cartao = (Cartao) entidade;
		String bandeira = cartao.getBandeira().getNome();
		boolean encontrado = false, naoEncontrado = false;
		
		bandeiras.add("Mastercard");
		bandeiras.add("Visa");
		bandeiras.add("Elo");
		bandeiras.add("American Express");
		bandeiras.add("Hipercard");
		bandeiras.add("Diners Club");
		
		for(String bnd : bandeiras) {
			if(bandeira.equals(bnd)) {
				encontrado = true;
				break;
			}else {
				naoEncontrado = true;
			}
		}
		if(!encontrado)
			return "Cartão inválido";
		else
			return null;
	}
}