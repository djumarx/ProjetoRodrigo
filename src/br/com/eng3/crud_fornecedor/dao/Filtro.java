package br.com.eng3.crud_fornecedor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.eng3.crud_fornecedor.dominio.Cartao;
import br.com.eng3.crud_fornecedor.dominio.Endereco;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Produto;
import br.com.eng3.crud_fornecedor.dominio.Usuario;

public class Filtro {
	private String query;
	private Map<String, String> mapNomeTabela;
	private Map<Integer, String> mapFiltroQuery;
	private List<Integer> listQueryFornecedor;
	private List<Integer> listQueryUsuario;
	private List<Integer> listQueryEndereco;
	private List<Integer> listQueryProduto;
	private List<Integer> listQueryCartao;
	
	private boolean flgEndereco = false;
	private boolean flgUsuario = false;
	private boolean flgFornecedor = false;
	private boolean flgCartao = false;
	private boolean flgProduto = false;
	
	public Filtro() {
		mapNomeTabela = new HashMap<String, String>();
		mapNomeTabela.put(Fornecedor.class.getName(), "tb_fornecedor");
		mapNomeTabela.put(Endereco.class.getName(), "tb_endereco");
		mapNomeTabela.put(Produto.class.getName(), "tb_produto");
		mapNomeTabela.put(Usuario.class.getName(), "tb_usuario");
		mapNomeTabela.put(Cartao.class.getName(), "tb_cartao");
		
	}
		public String gerarQuery(Fornecedor fornecedor) {
			query = "SELECT * FROM tb_fornecedor as F";
			
			mapFiltroQuery = new HashMap<Integer, String>();
			
			String selectEndereco = null;
			String selectUsuario = null;
			String selectProduto = null;
			String selectCartao = null;
			
			if (fornecedor.getUsuario() != null)
				selectUsuario = queryUsuario(fornecedor.getUsuario());
			
			if(flgUsuario)
				query += selectUsuario;
			else
				query += ", tb_usuario as U";
			
			
			if (fornecedor.getEndereco() != null)
				selectEndereco = queryEndereco(fornecedor.getEndereco().get(0));
			
			if(flgEndereco)
				query += selectEndereco;
			else
				query += ", tb_endereco as E";
			
			if (fornecedor.getCartao() != null)
				selectCartao = queryCartao((Cartao) fornecedor.getCartao());
			
			if(flgCartao)
				query += selectCartao;
			else
				query += ", tb_cartao as C";
			
			
			if (fornecedor.getProduto() != null)
				selectProduto = queryProduto(fornecedor.getProduto().get(0));
			
			if(flgProduto)
				query += selectProduto;
			else
				query += ", tb_produto as P";
			
			String selectFornecedor = queryFornecedor(fornecedor);
			if(flgFornecedor) 
				query += " WHERE " + selectFornecedor + " AND F.id_forn = E.id_end_forn "
						+ "AND F.id_forn = U.id_usu_forn AND F.id_forn = P.id_prod_forn AND "
						+ "F.id_forn = U.id_cartao_forn";
				
			else  if(!flgFornecedor)
				query += " WHERE F.id_forn = E.id_end_for AND F.id_forn = U.id_usu_forn"
						+ "AND F.id_forn = P.id_prod_forn AND F.id_forn = U.id_cartao_forn";
			
			
			System.out.println(query);
			return query;
		}
		
		private String queryFornecedor(Fornecedor fornecedor) {
			boolean flgWhere = false;
			String selectfornecedor = ", (SELECT * FROM tb_fornecedor";
			listQueryFornecedor = new ArrayList<Integer>();
			
			// id
			if (fornecedor.getId() > 0) {
				mapFiltroQuery.put(0, "id_forn = " + fornecedor.getId());
				listQueryFornecedor.add(0);
				flgFornecedor = true;
				flgWhere = true;
			}
			// nome
			if (fornecedor.getNome() != null) {
				if(!fornecedor.getNome().trim().equals("") ) {
					mapFiltroQuery.put(1, "nome_forn LIKE '%"+fornecedor.getNome()+"%'");
					listQueryFornecedor.add(1);
					flgWhere = true;
					flgFornecedor = true;
				}
			}
			// cpf
			if (fornecedor.getCnpj() != null) {
				if(!fornecedor.getCnpj().trim().equals("")) {
					mapFiltroQuery.put(2, "cnpj_forn LIKE '%"+fornecedor.getCnpj()+"%'");
					listQueryFornecedor.add(2);
					flgWhere = true;
					flgFornecedor = true;
				}
			}
			// genero
			if(fornecedor.getGenero() != null) {
				if(!fornecedor.getGenero().trim().equals("")){
					mapFiltroQuery.put(3, "genero_forn LIKE '%"+fornecedor.getGenero()+"%'");
					listQueryFornecedor.add(3);
					flgWhere = true;
					flgFornecedor = true;
				}
			}
			// ranking
			if(fornecedor.getGenero() != null) {
				if(!fornecedor.getGenero().trim().equals("")){
					mapFiltroQuery.put(4, "ranking_forn LIKE '%"+fornecedor.getGenero()+"%'");
					listQueryFornecedor.add(4);
					flgWhere = true;
					flgFornecedor = true;
					}
			}
			//dt nascimento
			if(fornecedor.getDtNascimento() != null) {
				if(!fornecedor.getDtNascimento().trim().equals("")) {
					mapFiltroQuery.put(5, "dtNasc_forn LIKE '%"+fornecedor.getDtNascimento()+"%'");
					listQueryFornecedor.add(5);
					flgWhere = true;
					flgFornecedor = true;
				}
			}
			// dt_cadastro
			if(fornecedor.getDtCadastro() != null) {
				if(!fornecedor.getDtCadastro().trim().equals("") ){
					mapFiltroQuery.put(6, "dtCadastro_forn LIKE '%"+fornecedor.getDtCadastro()+"%'");
					listQueryFornecedor.add(6);
					flgWhere = true;
					flgFornecedor = true;
				}
			}
			
			// tp telefone
			if(fornecedor.getTelefone().getTipoNumero() != null) {
				if(!fornecedor.getTelefone().getTipoNumero().trim().equals("")) {
					mapFiltroQuery.put(7, "tpTelefone_forn LIKE '%"+fornecedor.getTelefone().getTipoNumero()+"%'");
					listQueryFornecedor.add(7);
					flgFornecedor = true;
					flgWhere = true;
				}
			}
			
			if(fornecedor.getTelefone() != null) {
				//ddd telefone
				if(fornecedor.getTelefone().getDdd() != null) {
					if(!fornecedor.getTelefone().getDdd().trim().equals("")) {
						mapFiltroQuery.put(8, "dddTelefone_forn LIKE '%"+fornecedor.getTelefone().getDdd()+"%'");
						listQueryFornecedor.add(8);
						flgFornecedor = true;
						flgWhere = true;
					}
				}
				// telefone
				if(fornecedor.getTelefone().getNumero() != null) {
					if(!fornecedor.getTelefone().getNumero().trim().equals("")) {
						mapFiltroQuery.put(9, "telefone_forn LIKE '%"+fornecedor.getTelefone().getNumero()+"%'");
						listQueryFornecedor.add(9);
						flgFornecedor = true;
						flgWhere = true;
					}
				}
			}
					
			// teve filtro?
			if(flgWhere) {
				for (Integer i : listQueryFornecedor) {
					if(i != listQueryFornecedor.get(0))
						selectfornecedor += " AND ";
					
					selectfornecedor += mapFiltroQuery.get(i);
					
				}
			}
			return selectfornecedor;
		}
		
		private String queryEndereco(Endereco endereco) {
			boolean flgWhere = false;
			String selectEndereco = ", (SELECT * FROM tb_endereco";
			listQueryEndereco = new ArrayList<Integer>();
			// VALIDAR ENDEREÇOS
			if (endereco != null) {
				// tp cobranca
				if(endereco.isCobranca()) {
					mapFiltroQuery.put(10, "cobranca_end = true");
					listQueryEndereco.add(10);
					flgWhere = true;
					flgEndereco = true;
				}
				// tp entrega
				if(endereco.isEntrega()) {
					mapFiltroQuery.put(11, "entrega_end = true");
					listQueryEndereco.add(11);
					flgWhere = true;
					flgEndereco = true;
				}
				// tp residencia
				if( endereco.getTipoResidencia() != null) {
					if(!endereco.getTipoResidencia().trim().equals("")) {
						mapFiltroQuery.put(12, "tipoResidencia_end LIKE '%" +endereco.getTipoResidencia() + "%'");
						listQueryEndereco.add(12);
						flgWhere = true;
						flgEndereco = true;
					}
				}
				// tp logradouro
				if(endereco.getTipoLogradouro() != null) {
					// tp logradouro
					if (endereco.getTipoLogradouro() != null) {
						if(!endereco.getTipoLogradouro().trim().equals("")) {
							mapFiltroQuery.put(13, "tipoLogradouro_end LIKE '%"+endereco.getTipoLogradouro() + "%'");
							listQueryEndereco.add(13);
							flgWhere = true;
							flgEndereco = true;
						}
					}

				}
				// nome do logradouro
				if(endereco.getLogradouro() != null) {
					if(!endereco.getLogradouro().trim().equals("")) {
						mapFiltroQuery.put(14, "nome_end LIKE '%"+endereco.getLogradouro()+"%'");
						listQueryEndereco.add(14);
						flgWhere = true;
						flgEndereco = true;
					}
				}
				// Nome
				if(endereco.getNome() != null) {
					if(!endereco.getNome().trim().equals("")) {
						mapFiltroQuery.put(15, "logradouro_end LIKE '%"+ endereco.getNome() + "%'");
						listQueryEndereco.add(15);
						flgWhere = true;
						flgEndereco = true;
					}
				}

				//numero
				if (endereco.getNumero() != null) {
					if(!endereco.getNumero().trim().equals("")) {
						mapFiltroQuery.put(16, "numero_end LIKE '%" + endereco.getNumero()+"%'");
						listQueryEndereco.add(16);
						flgWhere = true;
						flgEndereco = true;
					}
				}
				// bairro
				if (endereco.getBairro() != null) {
					if(!endereco.getBairro().trim().equals("")) {
						mapFiltroQuery.put(17, "bairro_end LIKE '%" + endereco.getBairro() +"%'");
						listQueryEndereco.add(17);
						flgWhere = true;
						flgEndereco = true;
					}
				}
				// cep
				if(endereco.getCep() != null) {
					if (!endereco.getCep().trim().equals("")) {
						mapFiltroQuery.put(18, "complemento_end LIKE '%" + endereco.getCep() + "%'");
						listQueryEndereco.add(18);
						flgWhere = true;
						flgEndereco = true;
					}
				}
				// cep
				if(endereco.getCep() != null) {
					if (!endereco.getCep().trim().equals("")) {
						mapFiltroQuery.put(19, "cep_end LIKE '%" + endereco.getCep() + "%'");
						listQueryEndereco.add(19);
						flgWhere = true;
						flgEndereco = true;
					}
				}

				if(endereco.getCidade() != null) {
					// CIDADE
					if(endereco.getCidade() != null) {
						if(!endereco.getCidade().trim().equals("")) {
							mapFiltroQuery.put(20, "cidade_end LIKE '%"+endereco.getCidade()+"%'");
							listQueryEndereco.add(20);
							flgWhere = true;
							flgEndereco = true;
						}
					}					
				}
				if(endereco.getEstado() != null){
					// Estado
					if(endereco.getEstado() != null) {
						if(!endereco.getEstado().trim().equals("")) {
							mapFiltroQuery.put(21, "estado_end LIKE '%"+endereco.getEstado()+"%'");
							flgWhere= true;
							flgEndereco = true;
							listQueryEndereco.add(21);
						}
					}
					
				}
				if(endereco.getPais() != null) {
					//PAIS
					if(endereco.getPais() != null) {
						if(!endereco.getPais().trim().equals("")) {
							mapFiltroQuery.put(22, "pais_end LIKE '%" +endereco.getPais()+"%'");
							listQueryEndereco.add(22);
							flgWhere = true;
							flgEndereco = true;
						}
					}
				}
				
				if(flgWhere) {
					selectEndereco += " WHERE ";
					for (Integer i : listQueryEndereco) {
						if(i != listQueryEndereco.get(0))
							selectEndereco += " AND ";
						selectEndereco += mapFiltroQuery.get(i);
						
					}
				}
				
				selectEndereco += ") AS E";
				return selectEndereco;
			}
			
			return null;
		}

		private String queryUsuario(Usuario usuario) {
			boolean flgWhere = false;
			String selectUsuario = ", (SELECT * FROM tb_usuario";

			listQueryUsuario = new ArrayList<Integer>();
			
			// USUARIO
			if (usuario != null) {
				if(usuario.getEmail() != null) {
					if(!usuario.getEmail().trim().equals("")) {
						mapFiltroQuery.put(23, "usuario_usu LIKE '%" + usuario.getEmail() +"%'");
						listQueryUsuario.add(23);
						flgWhere = true;
						flgUsuario = true;
					}
				}
				
				// ativo
				if(usuario.isUsuarioAtivo()) {
					mapFiltroQuery.put(24, "ativo_inativo_usu = true");
					listQueryUsuario.add(24);
					flgWhere = true;
					flgUsuario = true;
				}
				else {
					mapFiltroQuery.put(25, "ativo_inativo_usu = false");
					listQueryUsuario.add(25);
					flgWhere = true;
					flgUsuario = true;
					
				}
				if(flgWhere) {
					selectUsuario += " WHERE ";
					for (Integer i : listQueryUsuario) {
						if(i != listQueryUsuario.get(0))
							selectUsuario += " AND ";
						selectUsuario += mapFiltroQuery.get(i);
					}	
				}
				selectUsuario += ") AS U";
				return selectUsuario;
			}
			return null;	
		}
		private String queryProduto(Produto produto) {
			boolean flgWhere = false;
			String selectProduto = ", (SELECT * FROM tb_produto";
			listQueryProduto = new ArrayList<Integer>();
			
			// Nome
			if (produto.getPreco() > 0) {
				mapFiltroQuery.put(26, "nome_forn = " + produto.getPreco());
				listQueryProduto.add(26);
				flgProduto = true;
				flgWhere = true;
			}
			// Preco
			if (produto.getNome() != null) {
				if(!produto.getNome().trim().equals("")) {
					mapFiltroQuery.put(27, "preco_forn LIKE '%"+produto.getNome()+"%'");
					listQueryProduto.add(27);
					flgWhere = true;
					flgProduto = true;
				}
			}
			// Descricao
			if (produto.getDescricao() != null) {
				if(!produto.getDescricao().trim().equals("")) {
					mapFiltroQuery.put(28, "descricao_forn LIKE '%"+produto.getDescricao()+"%'");
					listQueryProduto.add(28);
					flgWhere = true;
					flgProduto = true;
				}
			}
			// Categoria
			if(produto.getCategoria() != null) {
				if(!produto.getCategoria().trim().equals("")){
					mapFiltroQuery.put(29, "categoria_forn LIKE '%"+produto.getCategoria()+"%'");
					listQueryProduto.add(29);
					flgWhere = true;
					flgProduto = true;
				}
			}
			// Categoria
			if(produto.isProdutoPadrao()) {
				mapFiltroQuery.put(30, "produto_forn LIKE '%"+produto.isProdutoPadrao()+"%'");
				listQueryProduto.add(30);
				flgWhere = true;
				flgProduto = true;
			}
								
			// teve filtro?
			if(flgWhere) {
				for (Integer i : listQueryProduto) {
					if(i != listQueryProduto.get(0))
						selectProduto += " AND ";
					
					selectProduto += mapFiltroQuery.get(i);
					
				}
			}
			return selectProduto;
		}
		private String queryCartao(Cartao cartao) {
			boolean flgWhere = false;
			String selectCartao = ", (SELECT * FROM tb_cartao";
			listQueryCartao = new ArrayList<Integer>();
			
			// Nome
			if (cartao.getNome() != null) {
				if(!cartao.getNome().trim().equals("") ) {
					mapFiltroQuery.put(31, "nome_forn LIKE '%"+cartao.getNome()+"%'");
					listQueryCartao.add(31);
					flgWhere = true;
					flgCartao = true;
				}
			}
			// Numero
			if (cartao.getNumero() != null) {
				if(!cartao.getNumero().trim().equals("") ) {
					mapFiltroQuery.put(32, "numero_forn LIKE '%"+cartao.getNumero()+"%'");
					listQueryCartao.add(32);
					flgWhere = true;
					flgCartao = true;
				}
			}
			// Descricao
			if (cartao.getCodSeguranca() != null) {
				if(!cartao.getCodSeguranca().trim().equals("")) {
					mapFiltroQuery.put(33, "codSeguranca_forn LIKE '%"+cartao.getCodSeguranca()+"%'");
					listQueryCartao.add(33);
					flgWhere = true;
					flgCartao = true;
				}
			}
			if (cartao.getBandeira() != null) {
				if(!(cartao.getBandeira() != null)) {
					mapFiltroQuery.put(34, "bandeira_forn LIKE '%"+cartao.getBandeira()+"%'");
					listQueryCartao.add(34);
					flgWhere = true;
					flgCartao = true;
				}
			}
								
			// teve filtro?
			if(flgWhere) {
				for (Integer i : listQueryCartao) {
					if(i != listQueryCartao.get(0))
						selectCartao += " AND ";
					
					selectCartao += mapFiltroQuery.get(i);
					
				}
			}
			return selectCartao;
		}	
	}