package menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import BO.AeroportoBO;
import model.Aeroporto;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AeroportoBO bo = new AeroportoBO();
		System.out.println("Sitema de gerenciamento de aeroporoto:");
		
	
		int x =0;
		
		// O menu fica DENTRO do while para repetir sempre que necessário
        while(x != 5) {
            System.out.println("\n=================================");
            System.out.println("1 - Salvar voo");
            System.out.println("2 - Buscar voo por número");
            System.out.println("3 - Buscar todos os voos");
            System.out.println("4 - Excluir voo");
            System.out.println("5 - Sair");
            System.out.println("=================================");
            System.out.print("Escolha uma opção: ");
            
            x = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do teclado
            
            switch (x) {
                case 1: 
                    System.out.println("\n--- Cadastrando Novo Voo ---");
                    System.out.print("Local do embarque: ");
                    String Embarque = sc.nextLine();
                    
                    System.out.print("Local do Desembarque: ");
                    String Desembarque = sc.nextLine();
                    
                    System.out.print("Número do voo (Ex: GOL123): ");
                    String numero_voo = sc.nextLine();
                    
                    System.out.print("Nome da companhia: ");
                    String companhia = sc.nextLine();
                    
                    System.out.print("Status do voo (Ex: Confirmado): ");
                    String status = sc.nextLine();
                
                    Aeroporto voo = new Aeroporto(Embarque, Desembarque, numero_voo, companhia, status);
                    
                    try {
                        bo.salvar(voo);
                        System.out.println("✅ Voo salvo com sucesso no banco de dados!");
                    } catch (SQLException e) {
                        System.out.println("❌ Erro ao salvar no banco!");
                        e.printStackTrace();
                    }
                    break; 
                
                case 2:
                	System.out.println("coloque no numero do voo:");
                	String numero = sc.next();
                	Aeroporto voobusca = bo.buscarpornumero(numero);
                	System.out.println(voobusca.toString());
                	break;
                case 3:
                	List<Aeroporto> lista = bo.Buscartudo();
                	for(Aeroporto list : lista) {
                		System.out.println(list.toString());
                	}
                	break;
                case 4:
                	System.out.println("insira o numero do voo que deseja excluir:");
                	String numeroex = sc.next();
                	bo.Excluir(numeroex);
                	break;
                	
                case 5:
                    System.out.println("Encerrando o sistema. Boa viagem!");
                    break;
                    
                default:
                    // Removido o throw para o programa não "explodir" na tela.
                    // Agora ele só avisa que a opção é inválida e volta pro menu.
                    System.out.println("Opção inválida! Digite um número de 1 a 5.");
                    break;
            }
        }
		
		
	}
	
	

}
