package BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.passageiroDAO;
import model.passageiros;

public class passageirosBO {

	passageiroDAO dao = new passageiroDAO();
	
	
	public boolean verificarcpf(String p) {
		if(p.length() < 11) {
			return false;
		}else {
			return true;
		}
	}
	public void Salvar(passageiros p) throws SQLException{
		
		
		 
		if(verificarcpf( p.getCpf())){
			System.out.println("Erro no cpf tente novamente");
			
		}else {
			 dao.Salvar(p);
		}
	}
	
	public void Atualizar(passageiros p) throws SQLException {
		if(verificarcpf(p.getCpf())){
			System.out.println("Erro no cpf tente novamente");
			
		}else {
			 dao.Atualizar(p);
		}
		
	}
	public void Excluir(int numero) {
		
		
		dao.Excluir(numero);
	}
	
	
	public void viwer(String cpf) {
		
		if(verificarcpf(cpf)) {
			System.out.println("Erro no cpf tente novamente");
		}else {
			dao.viwer(cpf);
		}
	
	}
	
	
}
