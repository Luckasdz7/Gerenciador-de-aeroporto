package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.passageiros;
import model.reservas;
import model.voos;
import util.Conexao;

public class resevasDAO {

	private Connection con;
	
	public resevasDAO() {
		con = new Conexao().conectar();
	}
	
	public void salvar(reservas re) throws SQLException {
		String sql = "INSERT INTO reservas (id_passageiros, id_voos, assento, data_reservar) VALUES (? ,? ,? ,? ) ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, re.getPassageiro().getId_passageiros());
		stmt.setInt(2, re.getVoo().getId_voo());
		stmt.setString(3, re.getAssento());
		stmt.setDate(4, new java.sql.Date(re.getData_reservar().getTime()));
		
		stmt.execute();
	}
	
	public void atualizar(reservas re) throws SQLException {
		String sql = "update reservas set id_passageiros = ? , id_voos = ?, assento = ?, data_reservar = ? where id_resevar = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, re.getPassageiro().getId_passageiros());
		stmt.setInt(2, re.getVoo().getId_voo());
		stmt.setString(3, re.getAssento());
		stmt.setDate(4, new java.sql.Date(re.getData_reservar().getTime()));
		stmt.setInt(5, re.getId_resevas());
		
		stmt.execute();
	}
	
	public void Excluir(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM reservas WHERE id_resevar = ?");
			
			stmt.setInt(1, id);
			stmt.execute(); 
	        
	        System.out.println("Reseva " + id + " excluído com sucesso!");
			
		}catch(SQLException e) {
			e.printStackTrace();
			  System.out.println("Erro ao excluir reseva de  " + id + "!");
		}
	}
	
	public List<reservas> mostrartudo() throws SQLException {
		
		List<reservas> listares = new ArrayList<>();
		String sql = "SELECT r.id_resevar, r.assento, r.data_reservar, " +
	             "p.id_passageiros, p.nome, p.cpf, " +
	             "v.id as id_voo, v.numero_voo " +
	             "FROM reservas r " +
	             "JOIN passageiros p ON r.id_passageiros = p.id_passageiros " +
	             "JOIN voos v ON r.id_voos = v.id";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			listares.add(mapear(rs));
		}
		return listares;
		
	}
	
	public List<reservas> buscarReservasPorVoo(int idVoo) throws SQLException {
	    List<reservas> lista = new ArrayList<>();
	    String sql = "SELECT r.id_resevar, r.assento, r.data_reservar, " +
	                 "p.id_passageiros, p.nome, p.cpf, " +
	                 "v.id as id_voo, v.numero_voo " +
	                 "FROM reservas r " +
	                 "JOIN passageiros p ON r.id_passageiros = p.id_passageiros " +
	                 "JOIN voos v ON r.id_voos = v.id " +
	                 "WHERE r.id_voos = ?"; 
	    
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setInt(1, idVoo);
	    ResultSet rs = stmt.executeQuery();
	    
	    while(rs.next()) {
	        lista.add(mapear(rs));
	    }
	    return lista;
	}
	
public List<reservas> mostraporcpf(String cpf) throws SQLException {
		
		List<reservas> listares = new ArrayList<>();
		String sql = "SELECT r.id_resevar, r.assento, r.data_reservar, " +
	             "p.id_passageiros, p.nome, p.cpf, " +
	             "v.id as id_voo, v.numero_voo " +
	             "FROM reservas r " +
	             "JOIN passageiros p ON r.id_passageiros = p.id_passageiros " +
	             "JOIN voos v ON r.id_voos = v.id " +
	             "WHERE p.cpf = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, cpf);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			listares.add(mapear(rs));
		}
		return listares;
		
	}

	
	
	
	private reservas mapear(ResultSet rs)  throws SQLException{
		reservas re = new reservas();
		
		re.setId_resevas(rs.getInt("id_resevar"));
		re.setAssento(rs.getString("assento"));
		re.setData_reservar(rs.getDate("data_reservar"));
		
		passageiros pa = new passageiros();
		
		pa.setId_passageiros(rs.getInt("id_passageiros"));
		pa.setNome(rs.getString("nome"));
		pa.setCpf(rs.getString("cpf"));
		
		
		
		
		voos v = new voos();
	    v.setId_voo(rs.getInt("id_voo"));                     
	    v.setNumero_voo(rs.getString("numero_voo"));
	    
	    
	    
	    re.setVoo(v);
	    re.setPassageiro(pa);
		
		
		return re;
	}
}
