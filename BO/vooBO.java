package BO;

import java.sql.SQLException;

import java.util.List;

import DAO.voosDao;
import model.voos;

public class vooBO {
	
	voosDao dao = new voosDao();
	
	public void salvar(voos a) throws SQLException {
		 dao.salvar(a);
	}
	
	public List<voos> Buscartudo(){
		return dao.Buscartudo();
	}
	
	public voos buscarpornumero(String numero) {
		return dao.buscarpornumero(numero);
	}
	
	public void Excluir(String numero) {
		dao.Excluir(numero);
	}
	public void Atualizar(voos a) throws SQLException {
		dao.atualizar(a);
	}
}
