package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import model.Aeroporto;
import util.Conexao;

public class AeroportoDAO {
	
	

	private Connection con;
	
	public AeroportoDAO() {
		con = new Conexao().conectar();
	}
	
	public Aeroporto salvar(Aeroporto a) throws SQLException {
		
		String sql = "INSERT INTO voos(Embarque, Desembarque, numero_voo, companhia,status_voo) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, a.getEmbarque());
		stmt.setString(2, a.getDesembarque());
		stmt.setString(3, a.getNumero_voo());
		stmt.setString(4, a.getCompanhia());
		stmt.setString(5, a.getStatus());
		
		stmt.execute();
		
		return a;
	}
	
	public List<Aeroporto> Buscartudo(){
		
		List<Aeroporto> listar = new ArrayList<>();
		try {
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM voos");
			ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			listar.add(mapear(rs));
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listar;
	}
	
	
	public Aeroporto buscarpornumero(String numero) {
		
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM voos where numero_voo = ?");
			stmt.setString(1, numero);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return mapear(rs);
			}
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public void Excluir(String numero) {
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM voos WHERE numero_voo = ?");
			
			stmt.setString(1, numero);
			stmt.execute(); 
	        
	        System.out.println("Voo " + numero + " excluído com sucesso!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	private Aeroporto mapear(ResultSet rs) throws SQLException {
		
		Aeroporto aero = new Aeroporto();
		aero.setEmbarque(rs.getString("Embarque"));
		aero.setDesembarque(rs.getString("Desembarque"));
		aero.setNumero_voo(rs.getString("numero_voo"));
		aero.setCompanhia(rs.getString("companhia"));
		aero.setStatus(rs.getString("status_voo"));
		return aero;
	}
	
	
}
