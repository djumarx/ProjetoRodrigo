package br.com.eng3.crud_fornecedor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.eng3.crud_fornecedor.dominio.Endereco;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Usuario;

public class DAOUsuario extends AbstractDAO{

	public DAOUsuario() {
		super("tb_usuario", "id_usuario");
	}
	
	public DAOUsuario(Connection conexao) {
		super(conexao, "tb_usuario", "id_usuario");
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		if(conexao == null)
			abrirConexao();
		else
			ctrlTransacao = false;
		
		Usuario usuario = (Usuario) entidade;
		PreparedStatement ps = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO " + nomeTabela + " (email_usuario, senha_usuario, "
				+ "tipo_usuario, usuarioAtivo_usuario) VALUES(?,?,?,?,?,?)");
		try {
			ps = conexao.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, usuario.getEmail());
			ps.setString(2,usuario.getSenha());
			ps.setBoolean(3, usuario.isTipo());
			ps.setBoolean(4, usuario.isUsuarioAtivo());
			ps.setInt(5, usuario.getId());
			ps.setString(6, usuario.getDtCadastro());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int id_usuario = 0;
			if(rs.next()) {
				id_usuario = rs.getInt(1);
			}
			usuario.setId(id_usuario);
			
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
		if (conexao == null)
			abrirConexao();
		else 
			ctrlTransacao = false;
		
		StringBuilder sql = new StringBuilder();
		PreparedStatement  ps = null;
		Usuario usuario = (Usuario)entidade;
		
		sql.append("UPDATE " + nomeTabela + " SET email_usuario=?, senha_usuario=?, "
				+ "tipo_usuario=?, usuarioAtivo_usuario=? WHERE " + idTable + "=?");
		
		try {
			conexao.setAutoCommit(false);
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.setBoolean(3, usuario.isTipo());
			ps.setBoolean(4, usuario.isUsuarioAtivo());
			ps.setInt(5, usuario.getId());
			
			ps.executeUpdate();
			
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
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return null;
	}
}