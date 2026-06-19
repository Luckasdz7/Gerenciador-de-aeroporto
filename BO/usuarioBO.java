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
}