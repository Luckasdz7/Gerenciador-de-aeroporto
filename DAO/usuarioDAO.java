package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.perfil;
import model.usuarios;
import util.Conexao;

public class usuarioDAO {

    private Connection con;

    public usuarioDAO() {
        con = new Conexao().conectar();
    }

    
    public usuarios buscarPorLogin(String login) {
        try {
            String sql = "SELECT * FROM usuarios WHERE login = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapear(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se não achar o usuário
    }

    private usuarios mapear(ResultSet rs) throws SQLException {
        usuarios u = new usuarios();
        u.setId_usuarios(rs.getInt("id_usuarios"));
        u.setLogin(rs.getString("login"));
        u.setSenha(rs.getString("senha"));
        
        
        String perfilDoBanco = rs.getString("perfil").toUpperCase(); 
        u.setPerfil(perfil.valueOf(perfilDoBanco));
        
        return u;
    }
}