package menu;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import BO.aeronaveBO;
import BO.passageirosBO;
import BO.reservaBO;
import BO.usuarioBO;
import BO.vooBO;
import model.aeronaves;
import model.passageiros;
import model.perfil;
import model.reservas;
import model.usuarios;
import model.voos;

public class menuaeroporto {

    static usuarioBO   usuBO = new usuarioBO();
    static vooBO       vBO   = new vooBO();
    static passageirosBO pBO = new passageirosBO();
    static reservaBO   rBO   = new reservaBO();
    static aeronaveBO  aBO   = new aeronaveBO();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("   SISTEMA DE GERENCIAMENTO DE AEROPORTO");
        System.out.println("=====================================");

        System.out.print("Login (ou aperte ENTER para entrar como Viewer): ");
        String login = sc.nextLine();

        if (login.trim().isEmpty()) {
            menuViewer(sc);
        } else {
            System.out.print("Senha: ");
            String senha = sc.nextLine();
            try {
                usuarios userLogado = usuBO.autenticar(login, senha);
                System.out.println("Login realizado! Perfil: " + userLogado.getPerfil());

                if (userLogado.getPerfil() == perfil.ADMIN) {
                    menuAdmin(sc);
                } else if (userLogado.getPerfil() == perfil.OPERADOR) {
                    menuOperador(sc);
                } else if (userLogado.getPerfil() == perfil.CLIENTE) {
                    menuCliente(sc);
                }
            } catch (Exception e) {
                System.out.println("Erro de autenticacao: " + e.getMessage());
            }
        }

        System.out.println("Sistema encerrado.");
        sc.close();
    }

    // ==========================================
    // MENUS POR PERFIL
    // ==========================================

    private static void menuViewer(Scanner sc) {
        int op = 0;
        while (op != 4) {
            System.out.println("\n--- VIEWER ---");
            System.out.println("1 - Buscar Voo");
            System.out.println("2 - Buscar Reserva por CPF");
            System.out.println("3 - Buscar Passageiro por CPF");
            System.out.println("4 - Sair");
            System.out.print("Opcao: ");
            op = sc.nextInt(); sc.nextLine();
            try {
                switch (op) {
                    case 1: buscarVooPorNumero(sc);  
                    break;
                    case 2: buscarReservaPorCpf(sc);  
                    break;
                    case 3: buscarPassageiroPorCpf(sc);
                    break;
                    case 4: break;
                    default: System.out.println("Opcao invalida.");
                }
            } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
        }
    }

    private static void menuCliente(Scanner sc) {
        int op = 0;
        while (op != 4) {
            System.out.println("\n--- CLIENTE ---");
            System.out.println("1 - Gerenciar meu cadastro");
            System.out.println("2 - Buscar Voo");
            System.out.println("3 - Ver minhas Reservas");
            System.out.println("4 - Sair");
            System.out.print("Opcao: ");
            op = sc.nextInt(); sc.nextLine();
            try {
                switch (op) {
                    case 1: submenuPassageiro(sc);
                    break;
                    case 2: buscarVooPorNumero(sc); 
                    break;
                    case 3: buscarReservaPorCpf(sc);
                    break;
                    case 4: break;
                    default: System.out.println("Opcao invalida.");
                }
            } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
        }
    }

    private static void menuOperador(Scanner sc) {
        int op = 0;
        while (op != 5) {
            System.out.println("\n--- OPERADOR ---");
            System.out.println("1 - Passageiros");
            System.out.println("2 - Reservas");
            System.out.println("3 - Consultar Voos");
            System.out.println("4 - Consultar Aeronave");
            System.out.println("5 - Sair");
            System.out.print("Opcao: ");
            op = sc.nextInt(); sc.nextLine();
            try {
                switch (op) {
                    case 1: submenuPassageiro(sc); 
                    break;
                    case 2: submenuReserva(sc);   
                    break;
                    case 3: submenuVooLeitura(sc); 
                    break;
                    case 4: buscarAeronavePorId(sc); 
                    break;
                    case 5: break;
                    default: System.out.println("Opcao invalida.");
                }
            } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
        }
    }

    private static void menuAdmin(Scanner sc) {
        int op = 0;
        while (op != 6) {
            System.out.println("\n--- ADMIN ---");
            System.out.println("1 - Passageiros");
            System.out.println("2 - Reservas");
            System.out.println("3 - Voos");
            System.out.println("4 - Aeronaves");
            System.out.println("5 - Usuarios");
            System.out.println("6 - Sair");
            System.out.print("Opcao: ");
            op = sc.nextInt(); sc.nextLine();
            try {
                switch (op) {
                    case 1: submenuPassageiro(sc); 
                    break;
                    case 2: submenuReserva(sc);     
                    break;
                    case 3: submenuVooAdmin(sc);     
                    break;
                    case 4: submenuAeronaveAdmin(sc); 
                    break;
                    case 5: submenuUsuarioAdmin(sc);
                    break;
                    case 6: break;
                    default: System.out.println("Opcao invalida.");
                }
            } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
        }
    }

    // ==========================================
    // SUBMENUS CRUD
    // ==========================================

    private static void submenuPassageiro(Scanner sc) throws Exception {
        int op = 0;
        while (op != 5) {
            System.out.println("\n--- PASSAGEIROS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por CPF");
            System.out.println("5 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome: ");   
                    String nome  = sc.nextLine();
                    System.out.print("CPF: ");     
                    String cpf   = sc.nextLine();
                    System.out.print("Email: ");    
                    String email = sc.nextLine();
                    System.out.print("Telefone: "); 
                    String tel   = sc.nextLine();
                    pBO.Salvar(new passageiros(nome, cpf, email, tel));
                    System.out.println("Passageiro cadastrado!");
                    break;

                case 2:
                    System.out.print("ID do passageiro: "); 
                    int idAt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");    
                    String nNome  = sc.nextLine();
                    System.out.print("Novo CPF: ");     
                    String nCpf   = sc.nextLine();
                    System.out.print("Novo email: ");    
                    String nEmail = sc.nextLine();
                    System.out.print("Novo telefone: "); 
                    String nTel   = sc.nextLine();
                    passageiros p = new passageiros(nNome, nCpf, nEmail, nTel);
                    p.setId_passageiros(idAt);
                    pBO.Atualizar(p);
                    System.out.println("Passageiro atualizado!");
                    break;

                case 3:
                    System.out.print("ID para excluir: "); 
                    int idDel = sc.nextInt();
                    sc.nextLine();
                    pBO.Excluir(idDel);
                    break;

                case 4:
                    buscarPassageiroPorCpf(sc);
                    break;

                case 5: break;
                default: System.out.println("Opcao invalida.");
            }
        }
    }

    private static void submenuReserva(Scanner sc) throws Exception {
        int op = 0;
        while (op != 6) {
            System.out.println("\n--- RESERVAS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar todas");
            System.out.println("5 - Buscar por CPF");
            System.out.println("6 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID do passageiro: "); 
                    int idPass = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("ID do voo: ");   
                    int idVoo  = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("Assento (ex 12A): ");
                    String assento  = sc.nextLine();
                    System.out.print("Data (dd/MM/yyyy): ");
                    String dataStr = sc.nextLine();
                    passageiros pSalvar = new passageiros();
                    pSalvar.setId_passageiros(idPass);
                    voos vSalvar = new voos();
                    vSalvar.setId_voo(idVoo);
                    reservas rSalvar = new reservas(pSalvar, vSalvar, assento, new SimpleDateFormat("dd/MM/yyyy").parse(dataStr));
                    rBO.salvar(rSalvar);
                    System.out.println("Reserva cadastrada!");
                    break;

                case 2:
                    System.out.print("ID da reserva: ");
                    int idRes  = sc.nextInt(); sc.nextLine();
                    System.out.print("ID do passageiro: "); 
                    int idPassAt = sc.nextInt(); sc.nextLine();
                    System.out.print("ID do voo: ");   
                    int idVooAt  = sc.nextInt(); sc.nextLine();
                    System.out.print("Assento (ex 12A): "); 
                    String assentoAt  = sc.nextLine();
                    System.out.print("Data (dd/MM/yyyy): ");
                    String dataStrAt = sc.nextLine();
                    passageiros pAt = new passageiros();
                    pAt.setId_passageiros(idPassAt);
                    voos vAt = new voos();
                    vAt.setId_voo(idVooAt);
                    reservas rAt = new reservas(pAt, vAt, assentoAt, new SimpleDateFormat("dd/MM/yyyy").parse(dataStrAt));
                    rAt.setId_resevas(idRes);
                    rBO.atualizar(rAt);
                    System.out.println("Reserva atualizada!");
                    break;

                case 3:
                    System.out.print("ID para excluir: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();
                    rBO.Excluir(idDel);
                    break;

                case 4:
                    List<reservas> todas = rBO.mostrartudo();
                    for (reservas r : todas) {
                    	System.out.println(r);
                    }
                    	
                    break;

                case 5:
                    buscarReservaPorCpf(sc);
                    break;

                case 6: break;
                default: System.out.println("Opcao invalida.");
            }
        }
    }

    private static void submenuVooAdmin(Scanner sc) throws Exception {
        int op = 0;
        while (op != 6) {
            System.out.println("\n--- VOOS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar todos");
            System.out.println("5 - Buscar por numero");
            System.out.println("6 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextInt(); 
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Embarque: ");     
                    String emb    = sc.nextLine();
                    System.out.print("Desembarque: ");      
                    String des    = sc.nextLine();
                    System.out.print("Numero (ex GOL123): "); 
                    String num   = sc.nextLine();
                    System.out.print("Companhia: ");        
                    String comp   = sc.nextLine();
                    System.out.print("Status: ");           
                    String status = sc.nextLine();
                    System.out.print("ID da aeronave: ");   
                    int idAero    = sc.nextInt();
                    sc.nextLine();
                    aeronaves aSalvar = new aeronaves();
                    aSalvar.setId_aeronaves(idAero);
                    vBO.salvar(new voos(emb, des, num, comp, status, aSalvar));
                    System.out.println("Voo cadastrado!");
                    break;

                case 2:
                    System.out.print("Embarque: ");         
                    String embAt    = sc.nextLine();
                    System.out.print("Desembarque: ");      
                    String desAt    = sc.nextLine();
                    System.out.print("Numero (ex GOL123): ");
                    String numAt   = sc.nextLine();
                    System.out.print("Companhia: ");       
                    String compAt   = sc.nextLine();
                    System.out.print("Status: ");          
                    String statusAt = sc.nextLine();
                    System.out.print("ID da aeronave: ");   
                    int idAeroAt    = sc.nextInt();
                    sc.nextLine();
                    aeronaves aAt = new aeronaves();
                    aAt.setId_aeronaves(idAeroAt);
                    vBO.Atualizar(new voos(embAt, desAt, numAt, compAt, statusAt, aAt));
                    System.out.println("Voo atualizado!");
                    break;

                case 3:
                    System.out.print("Numero do voo para excluir: ");
                    String numDel = sc.nextLine();
                    vBO.Excluir(numDel);
                    break;

                case 4:
                    List<voos> lista = vBO.Buscartudo();
                    for (voos v : lista) {
                    	System.out.println(v);
                    }
                    break;

                case 5:
                    buscarVooPorNumero(sc);
                    break;

                case 6: break;
                default: System.out.println("Opcao invalida.");
            }
        }
    }

    private static void submenuAeronaveAdmin(Scanner sc) throws Exception {
        int op = 0;
        while (op != 5) {
            System.out.println("\n--- AERONAVES ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por ID");
            System.out.println("5 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Modelo (ex Boeing 737): "); 
                    String mod = sc.nextLine();
                    System.out.print("Capacidade: ");            
                    int cap    = sc.nextInt(); 
                    sc.nextLine();
                    aBO.salvar(new aeronaves(mod, cap));
                    System.out.println("Aeronave cadastrada!");
                    break;

                case 2:
                    System.out.print("ID para atualizar: ");    
                    int idAt  = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo modelo: ");          
                    String nMod = sc.nextLine();
                    System.out.print("Nova capacidade: ");      
                    int nCap    = sc.nextInt(); 
                    sc.nextLine();
                    aeronaves aAt = new aeronaves(nMod, nCap);
                    aAt.setId_aeronaves(idAt);
                    aBO.atualizar(aAt);
                    System.out.println("Aeronave atualizada!");
                    break;

                case 3:
                    System.out.print("ID para excluir: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();
                    aBO.Excluir(idDel);
                    break;

                case 4:
                    buscarAeronavePorId(sc);
                    break;

                case 5: break;
                default: System.out.println("Opcao invalida.");
            }
        }
    }

    private static void submenuUsuarioAdmin(Scanner sc) throws Exception {
        int op = 0;
        while (op != 5) {
            System.out.println("\n--- USUARIOS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Visualizar por ID");
            System.out.println("5 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Login: ");  
                    String login = sc.nextLine();
                    System.out.print("Senha: "); 
                    String senha = sc.nextLine();
                    System.out.print("Perfil (ADMIN/OPERADOR/CLIENTE): "); 
                    String perf = sc.nextLine();
                    usuarios novo = new usuarios();
                    novo.setLogin(login);
                    novo.setSenha(senha);
                    novo.setPerfil(perfil.valueOf(perf.toUpperCase()));
                    usuBO.salvar(novo);
                    System.out.println("Usuario cadastrado!");
                    break;

                case 2:
                    System.out.print("ID para atualizar: ");
                    int idAt = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("Novo login: ");
                    String nLogin = sc.nextLine();
                    System.out.print("Nova senha: ");
                    String nSenha = sc.nextLine();
                    System.out.print("Novo perfil (ADMIN/OPERADOR/CLIENTE): "); 
                    String nPerf = sc.nextLine();
                    usuarios atualizando = new usuarios();
                    atualizando.setId_usuarios(idAt);
                    atualizando.setLogin(nLogin);
                    atualizando.setSenha(nSenha);
                    atualizando.setPerfil(perfil.valueOf(nPerf.toUpperCase()));
                    usuBO.atualizar(atualizando);
                    System.out.println("Usuario atualizado!");
                    break;

                case 3:
                    System.out.print("ID para excluir: "); 
                    int idDel = sc.nextInt(); 
                    sc.nextLine();
                    usuBO.excluir(idDel);
                    break;

                case 4:
                    System.out.print("ID para visualizar: "); 
                    int idVer = sc.nextInt();
                    sc.nextLine();
                    usuBO.visualizar(idVer);
                    break;

                case 5: break;
                default: System.out.println("Opcao invalida.");
            }
        }
    }

    // ==========================================
    // CONSULTAS AUXILIARES
    // ==========================================

    private static void submenuVooLeitura(Scanner sc) {
        System.out.println("\n1 - Listar todos  |  2 - Buscar por numero");
        System.out.print("Opcao: ");
        int op = sc.nextInt(); sc.nextLine();
        try {
            if (op == 1) {
                List<voos> lista = vBO.Buscartudo();
                for (voos v : lista) {
                	System.out.println(v);
                }
            } else if (op == 2) {
                buscarVooPorNumero(sc);
            }
        } catch (Exception e) {
        	System.out.println("Erro: " + e.getMessage()); 
        	}
    }

    private static void buscarVooPorNumero(Scanner sc) throws Exception {
        System.out.print("Numero do voo: ");
        String num = sc.nextLine();
        voos v = vBO.buscarpornumero(num);
        if (v != null) { 
        	System.out.println(v);
        }else {
        	System.out.println("Voo nao encontrado.");
        }
    }

    private static void buscarReservaPorCpf(Scanner sc) throws Exception {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        List<reservas> lista = rBO.mostraporcpf(cpf);
        if (lista == null || lista.isEmpty()) {
        	System.out.println("Nenhuma reserva encontrada.");
        }
        else {
        	for (reservas r : lista) {
        		System.out.println(r);
        	}
        }
    }

    private static void buscarPassageiroPorCpf(Scanner sc) throws Exception {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        pBO.viwer(cpf);
    }

    private static void buscarAeronavePorId(Scanner sc) throws Exception {
        System.out.print("ID da aeronave: ");
        int id = sc.nextInt(); sc.nextLine();
        aeronaves a = aBO.buscarPorId(id);
        if (a != null) {
        	System.out.println(a);
        }else {        
        	   System.out.println("Aeronave nao encontrada.");
        }
    }
}