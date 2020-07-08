package br.com.eng3.crud_fornecedor.web.fachada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.eng3.crud_fornecedor.dao.DAOCartao;
import br.com.eng3.crud_fornecedor.dao.DAOEndereco;
import br.com.eng3.crud_fornecedor.dao.DAOFornecedor;
import br.com.eng3.crud_fornecedor.dao.DAOProduto;
import br.com.eng3.crud_fornecedor.dao.DAOUsuario;
import br.com.eng3.crud_fornecedor.dao.IDAO;
import br.com.eng3.crud_fornecedor.dominio.Cartao;
import br.com.eng3.crud_fornecedor.dominio.Endereco;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Produto;
import br.com.eng3.crud_fornecedor.dominio.Resultado;
import br.com.eng3.crud_fornecedor.dominio.Usuario;
import br.com.eng3.crud_fornecedor.web.negocio.CompletarDtCadastro;
import br.com.eng3.crud_fornecedor.web.negocio.CompletarRanking;
import br.com.eng3.crud_fornecedor.web.negocio.IStrategy;
import br.com.eng3.crud_fornecedor.web.negocio.ValidarBandeira;
import br.com.eng3.crud_fornecedor.web.negocio.ValidarCnpj;
import br.com.eng3.crud_fornecedor.web.negocio.ValidarEndEntregaCobranca;
import br.com.eng3.crud_fornecedor.web.negocio.ValidarEndereco;
import br.com.eng3.crud_fornecedor.web.negocio.ValidarExistencia;
import br.com.eng3.crud_fornecedor.web.negocio.ValidarProdutoPadrao;
import br.com.eng3.crud_fornecedor.web.negocio.ValidarSenha;
import br.com.eng3.crud_fornecedor.web.negocio.ValidarTelefone;

public class Fachada implements IFachada{
	private Map<String, IDAO> daos;
	private Map<String, List<IStrategy>> rngs;
	private StringBuilder msgErro = new StringBuilder();
	Resultado resultado = null;
	
	IDAO dao = null;
	
	String nomeClasse = null;
	
	List<IStrategy> rng = null;
	
	public Fachada() {
		daos = new HashMap<String, IDAO>();
		rngs = new HashMap<String, List<IStrategy>>();
		
		daos.put(Fornecedor.class.getName(), new DAOFornecedor());
		daos.put(Endereco.class.getName(), new DAOEndereco());
		daos.put(Produto.class.getName(), new DAOProduto());
		daos.put(Usuario.class.getName(), new DAOUsuario());
		daos.put(Cartao.class.getName(), new DAOCartao());
		
		List<IStrategy> rngFornecedor = new ArrayList<IStrategy>();
		List<IStrategy> rngEndereco = new ArrayList<IStrategy>();
		List<IStrategy> rngProduto = new ArrayList<IStrategy>();
		List<IStrategy> rngUsuario = new ArrayList<IStrategy>();
		List<IStrategy> rngCartao = new ArrayList<IStrategy>();
		
		// Criar Objetos das Regras de Negócio
		IStrategy complementarDtCadastro = new CompletarDtCadastro();
		IStrategy vlCPF = new ValidarCnpj();
		IStrategy vlEndereco = new ValidarEndereco();
		IStrategy vlExistencia = new ValidarExistencia();
		IStrategy vlSenha = new ValidarSenha();
		IStrategy vlTelefone = new ValidarTelefone();
		IStrategy vlEndEntregaCobranca = new ValidarEndEntregaCobranca();
		IStrategy vlBandeira = new ValidarBandeira();
		IStrategy vlProdutoPadrao = new ValidarProdutoPadrao();
		IStrategy vlRanking = new CompletarRanking();

		// FORNECEDOR
		rngFornecedor.add(complementarDtCadastro);
		rngFornecedor.add(vlCPF);
		rngFornecedor.add(vlExistencia);
		rngFornecedor.add(vlTelefone);
		rngFornecedor.add(vlEndEntregaCobranca);
		rngFornecedor.add(vlRanking);
				
		// USUARIO
		rngUsuario.add(complementarDtCadastro);
		rngUsuario.add(vlSenha);
		
		// ENDEREÇO
		rngEndereco.add(complementarDtCadastro);
		rngEndereco.add(vlEndereco);
		
		// PRODUTO
		rngProduto.add(complementarDtCadastro);
		rngProduto.add(vlProdutoPadrao);
		
		// CARTÃO
		rngCartao.add(complementarDtCadastro);
		rngCartao.add(vlBandeira);
						
		// COLOCAR REGRA DE NEGOCIO NO MAP 
		rngs.put(Fornecedor.class.getName(), rngFornecedor);
		rngs.put(Usuario.class.getName(), rngUsuario);
		rngs.put(Endereco.class.getName(), rngEndereco);
		rngs.put(Produto.class.getName(), rngProduto);
		rngs.put(Cartao.class.getName(), rngCartao);
	}
	
	// Executar todas as Regras de negocios
	private void executarRegras(List<IStrategy> rngEntidade, EntidadeDominio entidade) {
		String msg = "";
		for (IStrategy strategy :rngEntidade) {
			msg = strategy.processar(entidade);
			if(msg != null) {
				msgErro.append(msg + "\n");
				System.out.println(msg);
			}
		}
	}
	
	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// Resultado
		resultado = new Resultado();
		// obter nome da classe
		nomeClasse = entidade.getClass().getName();
		// regras de negocio
		rng = rngs.get(nomeClasse);
		// zerar a minha string
		msgErro.setLength(0);
		
		// executar regras de negocio
		executarRegras(rng, entidade);
		
		// verificar se é um cliente pq cliente tem q verificar alem dos dados dele
		// tem q validar os dados de end e usu
		if (nomeClasse == Fornecedor.class.getName()) {
			Fornecedor fornecedor = (Fornecedor) entidade;
		
			// executar regras dos endereços
			List<IStrategy> rngEnd = rngs.get(Endereco.class.getName());
			for(Endereco end : fornecedor.getEndereco())
				executarRegras(rngEnd, end);
			
			// executar regras do usuário
			Usuario usuario = fornecedor.getUsuario();
			List<IStrategy> rngUsu = rngs.get(Usuario.class.getName());
			executarRegras(rngUsu, fornecedor.getUsuario());
			
			// executar regras dos cartoes
			List<IStrategy> rngCartao = rngs.get(Cartao.class.getName());
			for(Cartao cartao : fornecedor.getCartao())
				executarRegras(rngCartao, cartao);
			
			// executar regras dos produtos
			List<IStrategy> rngProduto = rngs.get(Produto.class.getName());
			for(Produto produto : fornecedor.getProduto())
				executarRegras(rngProduto, produto);
			
		}
		
		// não teve nenhuma msg de erro
		if (msgErro.length() == 0 || msgErro.toString().trim().equals("")) {
			try {
				dao = daos.get(nomeClasse);
				System.out.println("To no dao indo salvar no DAOCliente");
				dao.salvar(entidade);
				resultado.add(entidade);
			}catch(Exception e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível Salvar...");
			}
		}
		else {
			
			resultado.add(entidade);
			resultado.setMsg(msgErro.toString());
		}
			
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();
		msgErro.setLength(0);
		
		nomeClasse = entidade.getClass().getName();
		
		executarRegras(rngs.get(nomeClasse), entidade);
		
		// verificar se é um cliente pq cliente tem q verificar alem dos dados dele
		// tem q validar os dados de end e usu
		if (nomeClasse == Fornecedor.class.getName()) {
			Fornecedor fornecedor = (Fornecedor) entidade;
		
			// executar regras dos endereços
			List<IStrategy> rngEnd = rngs.get(Endereco.class.getName());
			for(Endereco end : fornecedor.getEndereco())
				executarRegras(rngEnd, end);
			
			// executar regras do usuário
			Usuario usuario = fornecedor.getUsuario();
			List<IStrategy> rngUsu = rngs.get(Usuario.class.getName());
			executarRegras(rngUsu, fornecedor.getUsuario());
			
			// executar regras dos cartoes
			List<IStrategy> rngCartao = rngs.get(Cartao.class.getName());
			for(Cartao cartao : fornecedor.getCartao())
				executarRegras(rngCartao, cartao);
			
			// executar regras dos produtos
			List<IStrategy> rngProduto = rngs.get(Produto.class.getName());
			for(Produto produto : fornecedor.getProduto())
				executarRegras(rngProduto, produto);
		}
		
		if (msgErro.toString().trim().equals("")) {
			try {
				dao = daos.get(nomeClasse);
				dao.alterar(entidade);
				resultado.add(entidade);
				
			}catch(Exception e) {
				e.printStackTrace();
				resultado.setMsg(msgErro + "\nNão foi possível alterar...");
			}
		}
		else {
			resultado.setMsg(msgErro.toString());
			resultado.add(entidade);
		}
		
		
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		msgErro.setLength(0);
		resultado = new Resultado();
		
		nomeClasse = entidade.getClass().getName();
		
		dao = daos.get(nomeClasse);
		try {
			resultado.setEntidades(dao.consultar(entidade));
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setMsg("Não foi possível realizar a consulta...");
		}
		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		
		resultado = new Resultado();
		
		dao = daos.get(nomeClasse);
		
		try{
			dao.excluir(entidade);
			resultado.add(entidade);
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setMsg("Não foi possível Excluir...");
		}
		return resultado;
	}

}
