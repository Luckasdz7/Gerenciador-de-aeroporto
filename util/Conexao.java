package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {

	public Connection conectar() {
		String url = "jdbc:mysql://localhost:3306/bancoaeroporto";
		String usuario = "root";
		String senha = "";
		
		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("conexao feita com sucesso");
			return conexao;
		}catch(SQLException e) {
			System.out.println("Deu erro ao conectar!");
			e.printStackTrace();
			return null;
		}
	}
}
