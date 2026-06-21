package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.passageiros;
import model.voos;
import util.Conexao;

public class passageiroDAO {


	private Connection con;
	
	public passageiroDAO() {
		con = new Conexao().conectar();
	}
	
	public void Salvar(passageiros p) throws SQLException {
		String sql = "INSERT INTO passageiros(nome, cpf, email, telefone) VALUES (? ,? ,? ,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, p.getNome());
		stmt.setString(2, p.getCpf());
		stmt.setString(3, p.getEmail());
		stmt.setString(4, p.getTelefone());
		
		stmt.execute();
	}
	
	
	public void Atualizar(passageiros p) throws SQLException {
		String sql = "UPDATE passageiros set nome = ? ,cpf  = ? ,email = ? ,telefone = ? WHERE id_passageiros = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, p.getNome());
		stmt.setString(2, p.getCpf());
		stmt.setString(3, p.getEmail());
		stmt.setString(4, p.getTelefone());
		stmt.setInt(5, p.getId_passageiros());
		
		stmt.execute();
		
	}
	
	public void Excluir(int numero) {
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM passageiros WHERE id_passageiros = ?");
			
			stmt.setInt(1, numero);
			stmt.execute(); 
	        
	        System.out.println("passageiro " + numero + " excluído com sucesso!");
			
		}catch(SQLException e) {
			e.printStackTrace();
			 System.out.println("Erro ao excluir passageiro " + numero + "");
		}
	}
	
	public passageiros buscarPorCpf(String cpf) {
	    try {
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM passageiros WHERE cpf = ?");
	        stmt.setString(1, cpf);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return mapear(rs);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
		
	

	private passageiros mapear(ResultSet rs) throws SQLException {
		
	
	passageiros p = new passageiros();
	p.setId_passageiros(rs.getInt("id_passageiros"));
	p.setNome(rs.getNString("nome"));
	p.setCpf(rs.getString("cpf"));
	p.setEmail(rs.getString("email"));
	p.setTelefone(rs.getString("telefone"));
	
		return p;
	}
}
