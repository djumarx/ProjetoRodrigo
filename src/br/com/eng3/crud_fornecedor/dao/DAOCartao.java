package br.com.eng3.crud_fornecedor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.eng3.crud_fornecedor.dominio.Cartao;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;

public class DAOCartao extends AbstractDAO{
	
	public DAOCartao() {
		super("tb_cartao", "id_cartao");
	}

	public DAOCartao(Connection conexao) {
		super(conexao, "tb_cartao", "id_cartao");
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		if(conexao == null)
			abrirConexao();
		else
			ctrlTransacao = false;
		
		Cartao cartao = (Cartao) entidade;
		PreparedStatement ps = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO " + nomeTabela + " (nome_cartao, numero_cartao, "
				+ "codSeguranca_cartao, bandeira_cartao) VALUES (?,?,?,?)");
		
		try {
			ps = conexao.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cartao.getNome());
			ps.setString(2, cartao.getNumero());
			ps.setString(4, cartao.getCodSeguranca());
			ps.setString(1, cartao.getBandeira().getNome());
			ps.setInt(5, cartao.getId());
			ps.setString(6, cartao.getDtCadastro());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int id_cartao = 0;
			if(rs.next()) {
				id_cartao = rs.getInt(1);
			}
			cartao.setId(id_cartao);
			
			conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			
			try {
				if(ctrlTransacao) {
					ps.close();
					conexao.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return null;
	}
}
