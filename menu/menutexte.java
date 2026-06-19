package menu;


		import java.sql.SQLException;
		import java.util.List;

		import DAO.passageiroDAO;
		import DAO.resevasDAO;
		import DAO.voosDao;
		import model.reservas;
		import model.voos;

		public class menutexte {

			public static void main(String[] args) {
				System.out.println("=== INICIANDO TESTES DE INTEGRAÇÃO DO SISTEMA ===\n");

				try {
					// 1. Testando o Voo e sua lista interna de Reservas (O mais importante!)
					System.out.println("--- 1. TESTE: BUSCAR VOO E SUAS RESERVAS ---");
					voosDao vDao = new voosDao();
					// Vamos buscar o voo 1 do nosso script SQL
					voos vooTest = vDao.buscarpornumero("GOL1010");

					if (vooTest != null) {
						System.out.println("Voo Encontrado: " + vooTest.getNumero_voo() + " | Companhia: " + vooTest.getCompanhia());
						System.out.println("Status: " + vooTest.getStatus() + " | Rota: " + vooTest.getEmbarque() + " -> " + vooTest.getDesembarque());
						
						// Aqui testamos se a lista encheu corretamente!
						List<reservas> reservasDesteVoo = vooTest.getListresevar();
						System.out.println("Total de passagens vendidas neste voo: " + reservasDesteVoo.size());
						
						for (reservas r : reservasDesteVoo) {
							System.out.println("  -> Passageiro: " + r.getPassageiro().getNome() + " | Assento: " + r.getAssento());
						}
					} else {
						System.out.println("Voo GOL1010 não encontrado. (Você rodou o script de INSERTS no MySQL?)");
					}


					// 2. Testando buscar Passageiro por CPF
					System.out.println("\n--- 2. TESTE: BUSCAR PASSAGEIRO POR CPF ---");
					passageiroDAO pDao = new passageiroDAO();
					// Vai chamar o método viwer que você criou
					pDao.viwer("111.111.111-11");


					// 3. Testando listar TODAS as Reservas com JOIN
					System.out.println("\n--- 3. TESTE: LISTAR TODAS AS RESERVAS GERAIS ---");
					resevasDAO rDao = new resevasDAO();
					List<reservas> todasReservas = rDao.mostrartudo();
					
					if(todasReservas.isEmpty()) {
						System.out.println("Nenhuma reserva encontrada no banco.");
					} else {
						for (reservas res : todasReservas) {
							System.out.println("Reserva ID: " + res.getId_resevas() + 
											   " | Voo: " + res.getVoo().getNumero_voo() + 
											   " | Passageiro: " + res.getPassageiro().getNome() +
											   " | Assento: " + res.getAssento());
						}
					}

				} catch (SQLException e) {
					System.out.println("\n❌ ERRO FATAL NO BANCO DE DADOS:");
					e.printStackTrace();
				}

				System.out.println("\n=== FIM DOS TESTES ===");
			}
		
		
	}


