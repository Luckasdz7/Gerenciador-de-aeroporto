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
    
    public void salvar(usuarios u) throws SQLException {
        String sql = "INSERT INTO usuarios(login, senha, perfil) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getSenha());
        stmt.setString(3, u.getPerfil().name());
        stmt.execute();
    }

    public void atualizar(usuarios u) throws SQLException {
        String sql = "UPDATE usuarios SET login = ?, senha = ?, perfil = ? WHERE id_usuarios = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getSenha());
        stmt.setString(3, u.getPerfil().name());
        stmt.setInt(4, u.getId_usuarios());
        stmt.execute();
    }

    public void excluir(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM usuarios WHERE id_usuarios = ?");
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("  Usuário " + id + " excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("  Erro ao excluir usuário " + id);
        }
    }

    public void visualizar(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios WHERE id_usuarios = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println(mapear(rs));
            } else {
                System.out.println("  Usuário não encontrado para o ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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