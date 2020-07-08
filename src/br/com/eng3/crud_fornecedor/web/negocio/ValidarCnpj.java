package br.com.eng3.crud_fornecedor.web.negocio;

import java.util.InputMismatchException;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;

public class ValidarCnpj implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		String vetorCNPJ = fornecedor.getCnpj();
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
	    if (entidade.equals("00000000000000") || entidade.equals("11111111111111") ||
	    	entidade.equals("22222222222222") || entidade.equals("33333333333333") ||
	    	entidade.equals("44444444444444") || entidade.equals("55555555555555") ||
	    	entidade.equals("66666666666666") || entidade.equals("77777777777777") ||
	    	entidade.equals("88888888888888") || entidade.equals("99999999999999") ||
	       (vetorCNPJ.length() != 14))
	       return "CNPJ inválido\n";
	 
	    char dig13, dig14;
	    int sm, i, r, num, peso;
	    try {
	      sm = 0;
	      peso = 2;
	      for (i=11; i>=0; i--) {
	        num = (int)(vetorCNPJ.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }
	 
	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig13 = '0';
	      else dig13 = (char)((11-r) + 48);
	 
	      // Calculo do 2o. Digito Verificador
	      sm = 0;
	      peso = 2;
	      for (i=12; i>=0; i--) {
	        num = (int)(vetorCNPJ.charAt(i)- 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }
	 
	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig14 = '0';
	      else dig14 = (char)((11-r) + 48);
	 
	      // Verifica se os dígitos calculados conferem com os dígitos informados.
	      if ((dig13 == vetorCNPJ.charAt(12)) && (dig14 == vetorCNPJ.charAt(13)))
	    	  return null;
	      else 
	    	  return "CNPJ inválido\n";
	    } catch (InputMismatchException erro) {
	    	return "CNPJ inválido\n";
	    }
	}
}