package BO;

import java.sql.SQLException;
import java.util.List;

import DAO.voosDao;
import model.voos;

public class vooBO {
	
	voosDao dao = new voosDao();
	
	
	private void validarDadosDoVoo(voos a) throws Exception {
		// Regra 1: Campos não podem ser nulos ou vazios
		if (a.getEmbarque() == null || a.getEmbarque().trim().isEmpty()) {
			throw new Exception("O local de embarque é obrigatório.");
		}
		if (a.getDesembarque() == null || a.getDesembarque().trim().isEmpty()) {
			throw new Exception("O local de desembarque é obrigatório.");
		}
		if (a.getNumero_voo() == null || a.getNumero_voo().trim().isEmpty()) {
			throw new Exception("O número do voo é obrigatório.");
		}
		if (a.getCompanhia() == null || a.getCompanhia().trim().isEmpty()) {
			throw new Exception("A companhia aérea é obrigatória.");
		}
		
		// Regra 2: Lógica física - Embarque e Desembarque não podem ser o mesmo lugar
		
		if (a.getEmbarque().equalsIgnoreCase(a.getDesembarque())) {
			throw new Exception("O local de embarque não pode ser o mesmo do desembarque.");
		}
		
		// Regra 3: Um voo precisa ter um avião associado
		if (a.getAeronaves() == null || a.getAeronaves().getId_aeronaves() <= 0) {
			throw new Exception("É necessário atribuir uma aeronave válida (ID) a este voo.");
		}
		
		// Regra 4: Status Padrão. Se o usuário não digitar um status, o sistema coloca um sozinho.
		if (a.getStatus() == null || a.getStatus().trim().isEmpty()) {
			a.setStatus("Agendado"); 
		}
	}
	
	public void salvar(voos a) throws SQLException, Exception {
		
		validarDadosDoVoo(a);
		
		// Regra 5: Verificar se já não existe um voo com esse mesmo número cadastrado no banco
		voos vooExistente = dao.buscarpornumero(a.getNumero_voo());
		if (vooExistente != null) {
			throw new Exception("Já existe um voo cadastrado com o número " + a.getNumero_voo() + ".");
		}
		
		dao.salvar(a); 
	}
	
	public void Atualizar(voos a) throws SQLException, Exception {
		
		validarDadosDoVoo(a);
		
		dao.atualizar(a);
	}
	
	public List<voos> Buscartudo() {
		return dao.Buscartudo();
	}
	
	public voos buscarpornumero(String numero) throws Exception {
		if (numero == null || numero.trim().isEmpty()) {
			throw new Exception("Para buscar um voo, você precisa digitar o número dele.");
		}
		return dao.buscarpornumero(numero);
	}
	
	public void Excluir(String numero) throws Exception {
		if (numero == null || numero.trim().isEmpty()) {
			throw new Exception("O número do voo não pode estar vazio para exclusão.");
		}
		
		voos vooExistente = dao.buscarpornumero(numero);
		
		// Regra 6: Voo precisa existir para ser apagado
		if (vooExistente == null) {
			throw new Exception("O voo informado não foi encontrado no sistema.");
		}
		
		
		dao.Excluir(numero);
	}
}