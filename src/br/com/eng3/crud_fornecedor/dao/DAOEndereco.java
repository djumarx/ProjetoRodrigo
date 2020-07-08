package br.com.eng3.crud_fornecedor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.eng3.crud_fornecedor.dominio.Endereco;
import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;

public class DAOEndereco extends AbstractDAO{

	public DAOEndereco() {
		super("tb_endereco", "id_end");
	}

	public DAOEndereco(Connection conexao) {
		super(conexao, "tb_endereco", "id_end");
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		if(conexao == null)
			abrirConexao();
		else
			ctrlTransacao = false;
		
		Endereco end = (Endereco) entidade;
		PreparedStatement ps = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO " + nomeTabela + " (entrega_end, cobranca_end, tipoResidencia_end, "
				+ "tipoLogradouro_end, nome_end, logradouro_end, numero_end, bairro_end, "
				+ "complemento_end, cep_end, cidade_end, estado_end, pais_end) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		try {
			ps = conexao.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, end.isEntrega());
			ps.setBoolean(2, end.isCobranca());
			ps.setString(3, end.getTipoResidencia());
			ps.setString(4, end.getTipoLogradouro());
			ps.setString(5, end.getNome());
			ps.setString(6, end.getLogradouro());
			ps.setString(7, end.getNumero());
			ps.setString(8, end.getBairro());
			ps.setString(9, end.getComplemento());
			ps.setString(10, end.getCep());
			ps.setString(11, end.getCidade());
			ps.setString(12, end.getEstado());
			ps.setString(13, end.getPais());
			ps.setInt(14, end.getId());
			ps.setString(15, end.getDtCadastro());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int id_endereco = 0;
			if(rs.next()) {
				id_endereco = rs.getInt(1);
			}
			end.setId(id_endereco);
			
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