package BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.passageiroDAO;
import model.passageiros;

public class passageirosBO {

	passageiroDAO dao = new passageiroDAO();
	
	
	public boolean verificarcpf(String p) {
		if(p.length() < 11) {
			return true;
		}else {
			return false;
		}
	}
	public void Salvar(passageiros p) throws Exception{
		
		
		 
		if(verificarcpf( p.getCpf())){
			throw new Exception("Passageiros ou voos não podem ser nulos!");
			
		}else {
			 dao.Salvar(p);
		}
	}
	
	public void Atualizar(passageiros p)  throws SQLException, Exception  {
		if(verificarcpf(p.getCpf())){
			throw new Exception("cpf INVALIDO ");
			
		}else {
			 dao.Atualizar(p);
		}
		
	}
	public void Excluir(int numero) {
		
		
		dao.Excluir(numero);
	}
	
	
	public void viwer(String cpf) throws SQLException, Exception{
		
		if(verificarcpf(cpf)) {
			throw new Exception("cpf INVALIDO ");
		}else {
			dao.viwer(cpf);
		}
	
	}
	
	
}
