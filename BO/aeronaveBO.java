package BO;

import java.sql.SQLException;
import java.util.List;

import DAO.aeronavesDAO;
import DAO.voosDao; // Importado para checar se o avião está em uso
import model.aeronaves;
import model.voos;

public class aeronaveBO {

	aeronavesDAO dao = new aeronavesDAO();
	
	
	private void validarDadosDaAeronave(aeronaves aero) throws Exception {
		
		if (aero.getModelos() == null || aero.getModelos().trim().isEmpty()) {
			throw new Exception("O modelo da aeronave é obrigatório (Ex: Boeing 737).");
		}
		
		
		if (aero.getCapacidade() <= 0) {
			throw new Exception("A capacidade de passageiros deve ser maior que zero.");
		}
		
	
		if (aero.getCapacidade() > 853) { // 853 é a capacidade máxima do Airbus A380, o maior avião do mundo
			throw new Exception("Capacidade irreal. O avião não pode ter mais que 853 assentos.");
		}
	}
	
	public void salvar(aeronaves aero) throws SQLException, Exception {
		
		validarDadosDaAeronave(aero);
		
		dao.Salvar(aero);
	}
	
	public void atualizar(aeronaves aero) throws SQLException, Exception {
		// Regra 4: Para atualizar, o objeto precisa ter um ID válido
		if (aero.getId_aeronaves() <= 0) {
			throw new Exception("ID da aeronave inválido para atualização.");
		}
		
		validarDadosDaAeronave(aero);
		
		dao.Atualizar(aero);
	}
	
	
	
	public aeronaves buscarPorId(int id) throws Exception {
		if (id <= 0) {
			throw new Exception("O ID da aeronave deve ser maior que zero.");
		}
		return dao.viwer(id); // Supondo que você criou esse método no DAO
	}
	
	public void Excluir(int id) throws Exception {
		if (id <= 0) {
			throw new Exception("ID inválido para exclusão.");
		}
		
		// Regra 5 Avançada: O avião está atrelado a algum voo?
		// Para fazer isso perfeitamente, o ideal seria ter um método no voosDao que busca voos por ID da aeronave.
		// Como proteção básica, tentamos buscar a aeronave primeiro para ver se ela existe.
		aeronaves aeroExistente = dao.viwer(id);
		
		if (aeroExistente == null) {
			throw new Exception("A aeronave informada não existe no sistema.");
		}
		
		// Se quiser implementar a verificação de voos, você chamaria o voosDao aqui.
		
		dao.Excluir(id);
	}
}