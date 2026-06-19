package menu;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import BO.vooBO;
import model.voos;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner sc = new Scanner(System.in);
		vooBO bo = new vooBO();
		System.out.println("Sitema de gerenciamento de aeroporoto:");
		
	
		int x =0;
		
		// O menu fica DENTRO do while para repetir sempre que necessário
        while(x != 6) {
            System.out.println("\n=================================");
            System.out.println("1 - Salvar voo");
            System.out.println("2 - Buscar voo por número");
            System.out.println("3 - Buscar todos os voos");
            System.out.println("4 - Atualizar os voos");
            System.out.println("5 - Excluir voo");
            System.out.println("6 - Sair");
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
                
                    voos voo = new voos(Embarque, Desembarque, numero_voo, companhia, status);
                    
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
                	voos voobusca = bo.buscarpornumero(numero);
                	System.out.println(voobusca.toString());
                	break;
                case 3:
                	List<voos> lista = bo.Buscartudo();
                	for(voos list : lista) {
                		System.out.println(list.toString());
                	}
                	break;
                case 4:
                	System.out.println("insira o numero do voo que deseja excluir:");
                	String numeroex = sc.next();
                	bo.Excluir(numeroex);
                	break;
                case 5:
                	System.out.print("Digite o número do voo que deseja atualizar: ");
                	String numerovoo = sc.next();
                	voos vooAtualizar = bo.buscarpornumero(numerovoo);
                	
                	
                	if (vooAtualizar != null) {
                        System.out.println("Deixe em branco e aperte ENTER para manter o valor atual.");

                        System.out.print("Local do embarque atual (" + vooAtualizar.getEmbarque() + "): ");
                        String novoEmbarque = sc.nextLine();
                        if (!novoEmbarque.isEmpty()) vooAtualizar.setEmbarque(novoEmbarque);

                        System.out.print("Local do Desembarque atual (" + vooAtualizar.getDesembarque() + "): ");
                        String novoDesembarque = sc.nextLine();
                        if (!novoDesembarque.isEmpty()) vooAtualizar.setDesembarque(novoDesembarque);

                        System.out.print("Número do voo atual (" + vooAtualizar.getNumero_voo() + "): ");
                        String novoNumero = sc.nextLine();
                        if (!novoNumero.isEmpty()) vooAtualizar.setNumero_voo(novoNumero);

                        System.out.print("Companhia atual (" + vooAtualizar.getCompanhia() + "): ");
                        String novaCompanhia = sc.nextLine();
                        if (!novaCompanhia.isEmpty()) vooAtualizar.setCompanhia(novaCompanhia);

                        System.out.print("Status do voo atual (" + vooAtualizar.getStatus() + "): ");
                        String novoStatus = sc.nextLine();
                        if (!novoStatus.isEmpty()) vooAtualizar.setStatus(novoStatus);

                        try {
                            bo.Atualizar(vooAtualizar);
                        } catch (SQLException e) {
                            System.out.println("❌ Erro ao atualizar no banco!");
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Voo não encontrado.");
                    }
                	
                	
                	break;
                	
                case 6:
                    System.out.println("Encerrando o sistema. Boa viagem!");
                    break;
                    
                default:
                    // Removido o throw para o programa não "explodir" na tela.
                    // Agora ele só avisa que a opção é inválida e volta pro menu.
                    System.out.println("Opção inválida! Digite um número de 1 a 5.");
                    break;
            }
        }
		*/
		
	}
	
	

}
