package BO;

import java.sql.SQLException;
import java.util.List;

import DAO.resevasDAO; // Usando exatamente o nome que está na sua imagem
import model.reservas;

public class reservaBO {

	resevasDAO dao = new resevasDAO();
	
	public boolean verificar(reservas re) {
		if(re.getPassageiro() == null || re.getVoo() == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void salvar(reservas re) throws SQLException, Exception {
		if(verificar( re) ) {
			System.out.println("passageiros ou voos nulos , não foi possivel salvar");
		}else {
			dao.salvar(re);
		}
		
		
		
		
	}
	
	public void atualizar(reservas re) throws SQLException, Exception {
		if(verificar( re) ) {
			System.out.println("passageiros ou voos nulos , não foi possivel salvar");
		}else {
			dao.atualizar(re);
		}
		
	}
	
	public void Excluir(int id) throws Exception {
		
		
		dao.Excluir(id);
	}
	
	public List<reservas> mostrartudo() throws SQLException {
		return dao.mostrartudo();
	}
	
	public List<reservas> mostraporcpf(String cpf) throws SQLException, Exception {
		if(cpf.length() < 11) {
			System.out.println("CPF INVALIDO, nao foi possivel fazer a executar");
			return null;
		}else {
			return dao.mostraporcpf(cpf);
		}
		
		
	}
}