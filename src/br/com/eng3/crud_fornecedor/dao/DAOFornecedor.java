package br.com.eng3.crud_fornecedor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import br.com.eng3.crud_fornecedor.dominio.Bandeira;
import br.com.eng3.crud_fornecedor.dominio.Cartao;
import br.com.eng3.crud_fornecedor.dominio.Endereco;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.dominio.Produto;
import br.com.eng3.crud_fornecedor.dominio.Telefone;
import br.com.eng3.crud_fornecedor.dominio.Usuario;

public class DAOFornecedor extends AbstractDAO{

	public DAOFornecedor() {
		super("tb_fornecedor","id_forn");
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		abrirConexao();
		
		Fornecedor fornecedor = (Fornecedor) entidade;
		PreparedStatement ps = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO " + nomeTabela + "(nome_forn, cnpj_forn, ranking_forn, "
				+ "genero_forn, dtNasc_forn, ddd_telefone_forn, telefone_forn, tp_telefone_forn)"
				+ " VALUES (?,?,?,?,?,?,?,?)");
		try {
			conexao.setAutoCommit(false);
			ps = conexao.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3, fornecedor.getRanking());
			ps.setString(4, fornecedor.getGenero());
			ps.setString(5, fornecedor.getDtNascimento());
			ps.setString(6, fornecedor.getTelefone().getDdd());
			ps.setString(7, fornecedor.getTelefone().getNumero());
			ps.setString(8, fornecedor.getTelefone().getTipoNumero());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			int id_fornecedor = 0;
			if(rs.next()) {
				id_fornecedor = rs.getInt(1);
			}
			fornecedor.setId(id_fornecedor);
			
			IDAO daoEndereco = new DAOEndereco(conexao);
			List<Endereco> listEndereco = fornecedor.getEndereco();
			ctrlTransacao = false;
			for(Endereco end : listEndereco) {
				end.setId(fornecedor.getId());
				daoEndereco.salvar(end);
			}
			
			IDAO daoProduto = new DAOProduto(conexao);
			List<Produto> listProduto = fornecedor.getProduto();
			ctrlTransacao = false;
			for(Produto prod : listProduto) {
				prod.setId(fornecedor.getId());
				daoProduto.salvar(prod);
			}
			
			IDAO daoCartao = new DAOEndereco(conexao);
			List<Cartao> listCartao = fornecedor.getCartao();
			ctrlTransacao = false;
			for(Cartao cartao : listCartao) {
				cartao.setId(fornecedor.getId());
				daoEndereco.salvar(cartao);
			}
			
			IDAO daoUsuario = new DAOUsuario(conexao);
			Usuario usu = fornecedor.getUsuario();
			usu.setId(fornecedor.getId());
			daoUsuario.salvar(usu);
			
			ctrlTransacao = true;
			
			conexao.commit();
		}catch(Exception e) {
			try {
				conexao.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				if(ctrlTransacao) {
					conexao.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		abrirConexao();
		
		Fornecedor fornecedor = (Fornecedor) entidade;
		StringBuilder sb = new StringBuilder();
		PreparedStatement ps = null;
		
		sb.append("UPDATE " + nomeTabela + " SET nome_forn=?, cnpj_forn=?, ranking_forn=?, "
				+ "genero_forn=?, dtNasc_forn=?, ddd_telefone_forn=?, telefone_forn=?, tp_telefone_forn=?"
				+ " WHERE " + idTable + "=?");
		
		try {
			conexao.setAutoCommit(false);
			ps = conexao.prepareStatement(sb.toString());
			
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3, fornecedor.getRanking());
			ps.setString(4, fornecedor.getGenero());
			ps.setString(5, fornecedor.getDtNascimento());
			ps.setString(6, fornecedor.getTelefone().getDdd());
			ps.setString(7, fornecedor.getTelefone().getNumero());
			ps.setString(8, fornecedor.getTelefone().getTipoNumero());
			ps.setInt(9, fornecedor.getId());
			
			ps.executeUpdate();
			
			IDAO daoUsuario = new DAOUsuario(conexao);
			daoUsuario.alterar(fornecedor.getUsuario());
			
			sb.setLength(0);
			sb.append("SELECT * FROM tb_endereco WHERE id_end = ?");
			
			ps = conexao.prepareStatement(sb.toString());
			ps.setInt(1, fornecedor.getId());
			
			ResultSet rs = ps.executeQuery();
			List<Endereco> enderecos = new ArrayList<Endereco>();
			while(rs.next()) {
				Endereco endereco = new Endereco(false, false,"", "", "", "", "", "", "", "", "", "", "");
				endereco.setId(rs.getInt("id_end"));
				enderecos.add(endereco);
			}
			
			IDAO daoEndereco = new DAOEndereco(conexao);
			for(Endereco end : enderecos) {
				daoEndereco.excluir(end);
			}
			
			for(Endereco end : fornecedor.getEndereco()) {
				end.setId(fornecedor.getId());
				daoEndereco.salvar(end);
			}
			
			conexao.commit();
		}catch(Exception e) {
			try {
				conexao.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				if(ctrlTransacao) {
					conexao.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		abrirConexao();
		
		Fornecedor fornecedor = (Fornecedor) entidade;
		PreparedStatement ps = null;
		List<EntidadeDominio> listFornecedores = null;
		
		Filtro filtro = new Filtro();
		
		Map<Integer, List<Endereco>> mapEndereco;
		Map<Integer, Endereco> listEnderecosJaExistentes;
		Map<Integer, Fornecedor> mapFornecedor;
		Map<Integer, Usuario> mapUsuario;
		Map<Integer, Produto> mapProduto;
		Map<Integer, Cartao> mapCartao;
		List<Fornecedor> listFornecedor;
		List<Produto> listProduto;
		List<Cartao> listCartao;
		
		String query = filtro.gerarQuery(fornecedor);
		
		try {
			listFornecedores = new ArrayList<EntidadeDominio>();
			ps = conexao.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			mapEndereco = new HashMap<Integer, List<Endereco>>();
			listEnderecosJaExistentes = new HashMap<Integer, Endereco>();
			mapFornecedor = new HashMap<Integer, Fornecedor>();
			mapUsuario = new HashMap<Integer, Usuario>();
			mapProduto = new HashMap<Integer, Produto>();
			mapCartao = new HashMap<Integer, Cartao>();
			listFornecedor = new ArrayList<Fornecedor>();
			listProduto = new ArrayList<Produto>();
			listCartao = new ArrayList<Cartao>();
			
			while(rs.next()) {
				Bandeira bandeira = new Bandeira(rs.getString("nome_bandeira"));
				
				Endereco endereco = new Endereco(rs.getBoolean("entrega_end"), rs.getBoolean("cobranca_end"), 
						rs.getString("tipoResidencia_end"), rs.getString("tipoLogradouro_end"), rs.getString("nome_end"), 
						rs.getString("logradouro_end"),rs.getString("numero_end"), rs.getString("bairro_end"), rs.getString("complemento_end"),
						rs.getString("cep_end"), rs.getString("cidade_end"), rs.getString("estado_end"), rs.getString("pais_end"));
				
				endereco.setId(rs.getInt("id_end"));
				endereco.setDtCadstro(rs.getString("dtCadastro_end"));
				
				Usuario usuario = new Usuario(rs.getString("email_usuario"),rs.getString("senha_usuario"),rs.getBoolean("tipo_usuario"),
						rs.getBoolean("usuarioAtivo_usuario"));
				usuario.setId(rs.getInt("id_usuario"));
				usuario.setDtCadstro(rs.getString("dtCadastro_usuario"));
				
				Cartao cartao = new Cartao(rs.getString("email_cartao"),rs.getString("senha_cartao"),rs.getString("tipo_cartao"), 
						bandeira);
				cartao.setId(rs.getInt("id_cartao"));
				cartao.setDtCadstro(rs.getString("dt_cadastro_cartao"));
				
				Produto produto = new Produto(rs.getString("nome_prod"),rs.getDouble("preco_prod"),
						rs.getString("descricao_prod"), rs.getString("categoria_prod"),rs.getBoolean("produtoPadrao_prod"));
				produto.setId(rs.getInt("id_prod"));
				produto.setDtCadstro(rs.getString("dtCadastro_prod"));
				
				Telefone telefone = new Telefone(rs.getString("dddTelefone_forn"), rs.getString("telefone_forn"), 
						rs.getString("tpTelefone_forn"));
				Fornecedor fornecedorBd = new Fornecedor(rs.getString("nome_forn"), rs.getString("cnpj_forn"), 
						 rs.getString("ranking_forn"),  rs.getString("genero_forn"),
						 rs.getString("dtNasc_forn"), null, telefone, null, null, null);
				
				fornecedorBd.setId(rs.getInt("id_forn"));
				fornecedorBd.setDtCadstro(rs.getString("dtCadastro_forn"));
				
				if(mapFornecedor.get(fornecedorBd.getId()) == null) {
					mapFornecedor.put(fornecedorBd.getId(), fornecedorBd);
					listFornecedor.add(fornecedorBd);
				}
				
				if(listEnderecosJaExistentes.get(endereco.getId()) == null) {
					listEnderecosJaExistentes.put(endereco.getId(), endereco);
					// mapa de cliente
					if(mapEndereco.get(fornecedorBd.getId()) == null) {
						List<Endereco> end = new ArrayList<Endereco>();
						end.add(endereco);
						mapEndereco.put(fornecedorBd.getId(), end);
					}
					else
						mapEndereco.get(fornecedorBd.getId()).add(endereco);
					
				}
				
				if (mapUsuario.get(fornecedorBd.getId()) == null) {
					mapUsuario.put(fornecedorBd.getId(), usuario);
				}
				
				if(mapProduto.get(fornecedorBd.getId()) == null) {
					mapProduto.put(fornecedorBd.getId(), produto);
					listFornecedor.add(fornecedorBd);
				}
				
				if(mapCartao.get(fornecedorBd.getId()) == null) {
					mapCartao.put(fornecedorBd.getId(), cartao);
					listFornecedor.add(fornecedorBd);
				}
				
			}
			
			for(Fornecedor forn : listFornecedor) {
				forn.setUsuario(mapUsuario.get(forn.getId()));
				forn.setEndereco(mapEndereco.get(forn.getId()));
				forn.setProduto((List<Produto>) mapProduto.get(forn.getId()));
				forn.setCartao((List<Cartao>) mapCartao.get(forn.getId()));
			}
			
			return listFornecedores;
		}catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}	
}