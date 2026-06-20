package BO;

import DAO.usuarioDAO;
import model.usuarios;

public class usuarioBO {

    usuarioDAO dao = new usuarioDAO();

   
    public usuarios autenticar(String login, String senhaDigitada) throws Exception {
        
       
        if (login == null || login.trim().isEmpty()) {
            throw new Exception("O campo de login não pode estar vazio.");
        }
        if (senhaDigitada == null || senhaDigitada.trim().isEmpty()) {
            throw new Exception("O campo de senha não pode estar vazio.");
        }
        
        
        usuarios usuarioEncontrado = dao.buscarPorLogin(login);
        
       
        if (usuarioEncontrado == null) {
            throw new Exception("Usuário não encontrado no sistema.");
        }
        
        
        if (!usuarioEncontrado.getSenha().equals(senhaDigitada)) {
            throw new Exception("Senha incorreta.");
        }
        
        
        return usuarioEncontrado;
    }
    
    public void salvar(usuarios u) throws Exception {
        if (u.getLogin() == null || u.getLogin().trim().isEmpty())
            throw new Exception("Login não pode ser vazio.");
        if (u.getSenha() == null || u.getSenha().trim().isEmpty())
            throw new Exception("Senha não pode ser vazia.");
        if (u.getPerfil() == null)
            throw new Exception("Perfil não pode ser nulo.");
        dao.salvar(u);
    }

    public void atualizar(usuarios u) throws Exception {
        if (u.getLogin() == null || u.getLogin().trim().isEmpty())
            throw new Exception("Login não pode ser vazio.");
        if (u.getSenha() == null || u.getSenha().trim().isEmpty())
            throw new Exception("Senha não pode ser vazia.");
        if (u.getPerfil() == null)
            throw new Exception("Perfil não pode ser nulo.");
        dao.atualizar(u);
    }

    public void excluir(int id) throws Exception {
        if (id <= 0) throw new Exception("ID inválido.");
        dao.excluir(id);
    }

    public void visualizar(int id) throws Exception {
        if (id <= 0) throw new Exception("ID inválido.");
        dao.visualizar(id);
    }
}