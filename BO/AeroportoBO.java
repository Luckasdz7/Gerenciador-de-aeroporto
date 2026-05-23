package BO;

import java.sql.SQLException;
import java.util.List;

import DAO.AeroportoDAO;
import model.Aeroporto;

public class AeroportoBO {
	
	AeroportoDAO dao = new AeroportoDAO();
	
	public Aeroporto salvar(Aeroporto a) throws SQLException {
		return dao.salvar(a);
	}
	
	public List<Aeroporto> Buscartudo(){
		return dao.Buscartudo();
	}
	
	public Aeroporto buscarpornumero(String numero) {
		return dao.buscarpornumero(numero);
	}
	
	public void Excluir(String numero) {
		dao.Excluir(numero);
	}
}
