package br.com.eng3.crud_fornecedor.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String senha = "admin";
		String url = "jdbc:mysql://localhost:3306/Fornecedor";
		String user = "root";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, senha, user);
		
		return conn;
	}
}
