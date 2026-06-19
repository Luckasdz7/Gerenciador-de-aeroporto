package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.aeronaves;
import model.passageiros;
import util.Conexao;

public class aeronavesDAO {

	private Connection con;
	
	public aeronavesDAO() {
		con = new Conexao().conectar();
	}
	
	public void Salvar(aeronaves a) throws SQLException {
		String sql = "INSERT INTO aeronaves(modelos, capacidade) VALUES (? ,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, a.getModelos());
		stmt.setInt(2, a.getCapacidade());
		
		
		stmt.execute();
	}
	
	
	public void Atualizar(aeronaves a) throws SQLException {
		String sql = "UPDATE aeronaves set modelos = ? ,capacidade  = ? WHERE id_aeronaves = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, a.getModelos());
		stmt.setInt(2, a.getCapacidade());
		stmt.setInt(3, a.getId_aeronaves());
		
		stmt.execute();
		
	}
	
	public void Excluir(int numero) {
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM aeronaves WHERE id_aeronaves = ?");
			
			stmt.setInt(1, numero);
			stmt.execute(); 
	        
	        System.out.println("aeronave " + numero + " excluído com sucesso!");
			
		}catch(SQLException e) {
			e.printStackTrace();
			 System.out.println("Erro ao excluir aeronave  " + numero + "");
		}
	}
	
	public aeronaves viwer(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM aeronaves where id_aeronaves = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			aeronaves a = null;
			if(rs.next()) {
				 a =  mapear(rs);
			}
			if (a != null) {
			   return a;
			} else {
			    System.out.println("aeronave não encontrada com o id: " + id);
			    return null;
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	private aeronaves mapear(ResultSet rs) throws SQLException {
		
	
		aeronaves p = new aeronaves();
		
		p.setId_aeronaves(rs.getInt("id_aeronaves"));
		p.setModelos(rs.getString("modelos"));
		p.setCapacidade(rs.getInt("capacidade"));
		return p;
	}
}


