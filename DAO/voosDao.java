package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import model.voos;
import util.Conexao;

public class voosDao {
	
	

	private Connection con;
	
	public voosDao() {
		con = new Conexao().conectar();
	}
	
	public void salvar(voos a) throws SQLException {
		
		String sql = "INSERT INTO voos(Embarque, Desembarque, numero_voo, companhia,status_voo) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, a.getEmbarque());
		stmt.setString(2, a.getDesembarque());
		stmt.setString(3, a.getNumero_voo());
		stmt.setString(4, a.getCompanhia());
		stmt.setString(5, a.getStatus());
		
		stmt.execute();
		
		//return a;
	}
	
	
	public void atualizar(voos a) throws SQLException {
		String sql = "update voos set Embarque = ? , Desembarque = ?, companhia = ?, status_voo = ? where numero_voo = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, a.getEmbarque());
		stmt.setString(2, a.getDesembarque());
		stmt.setString(3, a.getCompanhia());
		stmt.setString(4, a.getStatus());
		stmt.setString(5, a.getNumero_voo());
		
		stmt.execute();
	}
	
	public List<voos> Buscartudo(){
		
		List<voos> listar = new ArrayList<>();
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
	
	
	public voos buscarpornumero(String numero) {
		
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
	private voos mapear(ResultSet rs) throws SQLException {
		
		voos aero = new voos();
		aero.setEmbarque(rs.getString("Embarque"));
		aero.setDesembarque(rs.getString("Desembarque"));
		aero.setNumero_voo(rs.getString("numero_voo"));
		aero.setCompanhia(rs.getString("companhia"));
		aero.setStatus(rs.getString("status_voo"));
		return aero;
	}
	
	
}
