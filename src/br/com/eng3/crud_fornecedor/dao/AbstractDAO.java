package br.com.eng3.crud_fornecedor.dao;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Fornecedor;
import br.com.eng3.crud_fornecedor.web.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractDAO implements IDAO {
	protected Connection conexao;
	protected String idTable;
	protected String nomeTabela;
	protected boolean ctrlTransacao = true;
	
	public AbstractDAO(Connection conexao, String nomeTabela, String idTable) {
		super();
		this.conexao = conexao;
		this.idTable = idTable;
		this.nomeTabela = nomeTabela;
	}
	
	public AbstractDAO(String nomeTabela, String idTable) {
		super();
		this.nomeTabela = nomeTabela;
		this.idTable = idTable;
	}
	
	public void abrirConexao() { 
		try {
			if (conexao == null || conexao.isClosed()) {
				conexao = Conexao.getConnection();
			}
		} catch (SQLException|ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Override
	public void excluir(EntidadeDominio entidade) {
		if(conexao == null)
			abrirConexao();
		else
			ctrlTransacao = false;
		
		PreparedStatement ps = null;
		StringBuilder query = new StringBuilder();
		
		if(!entidade.getClass().getName().equals(Fornecedor.class.getName())) {
			query.append("DELETE FROM " + nomeTabela + " WHERE " + idTable + " = ?");
			try {
				conexao.setAutoCommit(false);
				ps = conexao.prepareStatement(query.toString());
				ps.setInt(1, entidade.getId());
				ps.executeUpdate();
				conexao.commit();
			}catch(SQLException e) {
				try {
					conexao.rollback();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				if(ctrlTransacao) {
					try {
						ps.close();
						if(ctrlTransacao) 
							conexao.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}else if(entidade.getClass().getName().equals(Fornecedor.class.getName())) {
			query.append("UPDATE tb_usuario SET ativo_inativo = false WHERE id_fornecedor = ?");
			try {
				conexao.setAutoCommit(false);
				ps = conexao.prepareStatement(query.toString());
				ps.setInt(1, entidade.getId());
				ps.executeUpdate();
				conexao.commit();
			}catch(Exception e) {
				try {
					conexao.rollback();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				if(ctrlTransacao) {
					try {
						ps.close();
						if(ctrlTransacao)
							conexao.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
}
