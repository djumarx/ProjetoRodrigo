package br.com.eng3.crud_fornecedor.web.util;

import java.util.ArrayList;
import java.util.List;

import br.com.eng3.crud_fornecedor.dao.Filtro;
import br.com.eng3.crud_fornecedor.dominio.Bandeira;
import br.com.eng3.crud_fornecedor.dominio.Cartao;
import br.com.eng3.crud_fornecedor.dominio.Endereco;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Produto;
import br.com.eng3.crud_fornecedor.dominio.Telefone;
import br.com.eng3.crud_fornecedor.dominio.Usuario;

public class TestarCodigo {
	public static void main(String[] args) {
		
		Filtro f = new Filtro();
		String filtro = f.gerarQuery(new Fornecedor(null, null, null, null, null, null, null, null, null, null));
		System.out.println(filtro);
	}
	
	public static Fornecedor criarFornecedor() {
		
		Endereco endereco = new Endereco(true, true, "casa", "rua", "minha casa", "rua dos babatais",
				"122", "Carrao", "", "08512452", "Poá", "São Paulo", "Brasil");
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(endereco);
		enderecos.add(endereco);
		
		Telefone telefone = new Telefone("11", "12142678", "celular");
		
		Usuario usuario = new Usuario("djumarx", "wings1997", false, true);
		
		Produto produto = new Produto("Celular", 1200, "Celular novo", "Tecnologia", true);
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(produto);
		produtos.add(produto);
		
		Bandeira bandeira = new Bandeira("Mastercard");
		
		Cartao cartao = new Cartao("Djulia Camargo", "1234567890123456", "123", bandeira);
		List<Cartao> cartoes = new ArrayList<Cartao>();
		cartoes.add(cartao);
		cartoes.add(cartao);
		
		Fornecedor fornecedor = new Fornecedor("Djulia Camargo", "93.365.250/0001-06","100", "F",
				"1997/01/04", enderecos, telefone, usuario, cartoes, produtos);
		
		return fornecedor;
		
	}
}
