package br.com.eng3.crud_fornecedor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.eng3.crud_fornecedor.dominio.EntidadeDominio;
import br.com.eng3.crud_fornecedor.dominio.Produto;

public class DAOProduto extends AbstractDAO{
	
	public DAOProduto() {
		super("tb_produto", "id_prod");
	}

	public DAOProduto(Connection conexao) {
		super(conexao, "tb_produto", "id_prod");
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		if(conexao == null)
			abrirConexao();
		else
			ctrlTransacao = false;
		
		Produto prod = (Produto) entidade;
		PreparedStatement ps = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO " + nomeTabela + " (nome_prod, preco_prod, "
				+ "descricao_prod, categoria_prod, produtoPadrao_prod) VALUES (?,?,?,?,?)");
		
		try {
			ps = conexao.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, prod.getNome());
			ps.setDouble(2, prod.getPreco());
			ps.setString(3, prod.getDescricao());
			ps.setString(4, prod.getCategoria());
			ps.setBoolean(5, prod.isProdutoPadrao());
			ps.setInt(6, prod.getId());
			ps.setString(7, prod.getDtCadastro());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int id_produto = 0;
			if(rs.next()) {
				id_produto = rs.getInt(1);
			}
			prod.setId(id_produto);
			
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
