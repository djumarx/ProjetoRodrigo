package br.com.eng3.crud_fornecedor.web.viewHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Produto;
import br.com.eng3.crud_fornecedor.dominio.Resultado;
import br.com.eng3.crud_fornecedor.dominio.Telefone;
import br.com.eng3.crud_fornecedor.dominio.Usuario;
import br.com.eng3.crud_fornecedor.dominio.Bandeira;
import br.com.eng3.crud_fornecedor.dominio.Cartao;
import br.com.eng3.crud_fornecedor.dominio.Endereco;

public class FornecedorVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		HttpSession session = null;
		Fornecedor fornecedor = null;
		String operacao = request.getParameter("OPERACAO");
		
		if(operacao.equals("SALVAR")) {
			fornecedor = criarFornecedor(request);
			
		}else if(operacao.equals("ALTERAR")) {
			fornecedor = criarFornecedor(request);
			fornecedor.setId(Integer.parseInt(request.getParameter("id")));
			
		}else if(operacao.equals("EXCLUIR")) {
			session = request.getSession();
			fornecedor = (Fornecedor) session.getAttribute("fornecedor");
			
		}else if(operacao.equals("PERFIL")) {
			int id_fornecedor = Integer.parseInt(request.getParameter("id"));
			fornecedor = new Fornecedor(null, null, null, null, null, null, null, null, null, null);
			fornecedor.setId(id_fornecedor);
		}else if(operacao.equals("PESQUISAR")) {
			fornecedor = criarFornecedor(request);
		}
		return fornecedor;
	}
	private Fornecedor criarFornecedor(HttpServletRequest request) {
		String operacao = request.getParameter("OPERACAO");
		
		Fornecedor fornecedor = null;
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String ranking = request.getParameter("ranking");
		String genero = request.getParameter("genero");
		String dtNascimento = request.getParameter("dtNascimento");
		
		String tipoTelefone = request.getParameter("tipoTelefone");
		String dddTelefone = request.getParameter("ddd");
		String numeroTelefone = request.getParameter("numeroTelefone");
		Telefone telefone = new Telefone(tipoTelefone, dddTelefone, numeroTelefone);

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		boolean cadastroAtivo = true;
		boolean adm = false;
		
		Usuario usuario = null;
		if (operacao.equals("PESQUISAR")) {
			String ativoInativo = request.getParameter("ativoInativo");
			cadastroAtivo = (ativoInativo.equals("Ativo")) ? true : false;
		}
		usuario = new Usuario(email, senha, adm, cadastroAtivo);
		
		int qntEnderecos;
		if(operacao.equals("SALVAR") || operacao.equals("ALTERAR"))
			qntEnderecos = Integer.parseInt(request.getParameter("qtdEnd"));
		else
			qntEnderecos = 1;
		
		List<Endereco> listEnderecos = new ArrayList<Endereco>();
		boolean entrega = false;
		boolean cobranca = false;
		for (int i = 0; i < qntEnderecos; i++) {
			entrega = false;
			cobranca = false;
			String tipoResidencia = request.getParameter("tipoResidencia" + (i+1));
			String tipoLogradouro = request.getParameter("tipoLogradouro" + (i+1));
			String nomeEnd = request.getParameter("nomeEndereco" + (i+1));
			String logradouro = request.getParameter("logradouro" + (i+1));
			String numero = request.getParameter("numero" + (i+1));
			String bairro = request.getParameter("bairro" + (i+1));
			String cep = request.getParameter("CEP"+(i+1));
			String pais = request.getParameter("pais" + (i+1));
			String estado = request.getParameter("estado" + (i+1));
			String cidade = request.getParameter("cidade" + (i+1));
			String complemento = request.getParameter("observacao" + (i+1));
			
			if(request.getParameter("entrega" + (i+1)) != null) 
				entrega = true;
			
			if(request.getParameter("cobranca" + (i+1)) != null)
				cobranca = true;
			
			Endereco endereco = new Endereco(entrega, cobranca, tipoResidencia, tipoLogradouro, 
					nomeEnd, logradouro, numero, bairro, complemento, cep, pais, estado, cidade);
			
			listEnderecos.add(endereco);
		}
		
		int qtdProduto;
		if(operacao.equals("SALVAR") || operacao.equals("ALTERAR"))
			qtdProduto = Integer.parseInt(request.getParameter("qtdProd"));
		else
			qtdProduto = 1;

		List<Produto> listProduto = new ArrayList<Produto>();
		boolean produtoPadrao = false;
		for (int i = 0; i < qtdProduto; i++) {
			String nomeProduto = request.getParameter("nomeProduto" + (i+1));
			double precoProduto = Double.parseDouble(request.getParameter("precoProduto" + (i+1)));
			String descricaoProduto = request.getParameter("descricaoProduto" + (i+1));
			String categoriaProduto = request.getParameter("categoriaProduto" + (i+1));
			if(request.getParameter("produtoPadrao" + (i+1)) != null) 
				produtoPadrao = true;
			
			Produto produto = new Produto(nomeProduto, precoProduto, descricaoProduto, categoriaProduto, produtoPadrao);
			
			listProduto.add(produto);
		}
		
		int qtdCartao;
		if(operacao.equals("SALVAR") || operacao.equals("ALTERAR"))
			qtdCartao = Integer.parseInt(request.getParameter("qtdProd"));
		else
			qtdCartao = 1;

		List<Cartao> listCartao = new ArrayList<Cartao>();
		for (int i = 0; i < qtdCartao; i++) {
			String nomeCartao = request.getParameter("nomeCartao" + (i+1));
			String numeroCartao = request.getParameter("numeroCartao" + (i+1));
			String codSegurancaCartao = request.getParameter("codSegurancaCartao" + (i+1));
			String nomeBandeira = request.getParameter("nomeBandeira" + (i+1));
			Bandeira nomeBC = new Bandeira(nomeBandeira);
			
			Cartao cartao = new Cartao(nomeCartao, numeroCartao, codSegurancaCartao, nomeBC);
			
			listCartao.add(cartao);
		}
		
		fornecedor = new Fornecedor(nome, cnpj, ranking, genero, dtNascimento, listEnderecos, telefone, usuario, listCartao, listProduto);
		
		return fornecedor;
	}
	@Override
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = null;
		String operacao = request.getParameter("OPERACAO");
		
		if(resultado.getMsg() != null && !resultado.getMsg().trim().equals("")) {
			request.getSession().setAttribute("resultado", resultado);
			rd = request.getRequestDispatcher("erro.jsp");
			
		}else if(operacao.equals("SALVAR")) {
			Fornecedor fornecedor = (Fornecedor) resultado.getEntidades().get(0);
			request.getSession().setAttribute("id_forn", fornecedor.getId());
			request.getSession().setAttribute("fornecedor", fornecedor);
			rd = request.getRequestDispatcher("perfil.jsp");
			
		}else if(operacao.equals("PESQUISAR")) {
			request.getSession().setAttribute("resultado", resultado);
			rd = request.getRequestDispatcher("resultado.jsp");
			
		}else if(operacao.equals("ALTERAR")) {
			Fornecedor fornecedor = (Fornecedor) resultado.getEntidades().get(0);
			request.getSession().setAttribute("fornecedor", fornecedor.getId());
			rd = request.getRequestDispatcher("perfil.jsp");
			
		}else if(operacao.equals("EXCLUIR")) {
			rd = request.getRequestDispatcher("home.jsp");
			
		}else if(operacao.equals("PERFIL")) {
			Fornecedor fornecedor = (Fornecedor) resultado.getEntidades().get(0);
			request.getSession().setAttribute("fornecedor", fornecedor.getId());
			rd = request.getRequestDispatcher("perfil.jsp");
			
		}
		rd.forward(request, response);
	}
}
