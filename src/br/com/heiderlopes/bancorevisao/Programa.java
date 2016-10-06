package br.com.heiderlopes.bancorevisao;

import java.util.Random;
import java.util.Scanner;

import br.com.heiderlopes.bancorevisao.dao.ContaDAO;
import br.com.heiderlopes.bancorevisao.dao.ContaDAOLista;
import br.com.heiderlopes.bancorevisao.excecao.ExcecaoElementoJaExistente;
import br.com.heiderlopes.bancorevisao.excecao.ExcecaoLimiteElementoExcedido;
import br.com.heiderlopes.bancorevisao.model.Cliente;
import br.com.heiderlopes.bancorevisao.model.Conta;

public class Programa {

	private static final int CADASTRAR 			= 1;
	private static final int APAGAR 			= 2;
	private static final int VERTODOS 			= 3;
	private static final int BUSCAR_POR_NUMERO 	= 4;
	private static final int SAIR 				= 0;
	
	private static Scanner entrada;

	private static ContaDAO dao;
	public static void main(String[] args) {

		entrada = new Scanner(System.in);
		
		dao = new ContaDAOLista();
		
		int op = 0;

		do {

			System.out.println("*************************");
			System.out.println("*    Banco Calzabe      *");
			System.out.println("*************************");

			System.out.println("1 - Cadastrar");
			System.out.println("2 - Apagar");
			System.out.println("3 - Mostrar todas as contas");
			System.out.println("4 - Pesquisar por numero da conta");
			System.out.println("0 - Sair");

			System.out.println("Digite a opcao desejada: ");

			try {
				op = Integer.parseInt(entrada.nextLine());

				switch (op) {
				case CADASTRAR:
					cadastrar();
					break;
				case APAGAR:
					break;
				case VERTODOS:
					break;
				case BUSCAR_POR_NUMERO:
					break;
				case SAIR:
					System.out.println("Sistema finalizado");
					break;
				}

			} catch (NumberFormatException nfe) {
				System.out.println("Informe um numero valido seu cabaco");
				op = -1;
			}

		} while (op != 0);
	}
	
	private static void cadastrar() {
		Cliente cliente = new Cliente();
		
		System.out.println("Informe o nome do cliente: ");
		cliente.setNome(entrada.nextLine());
		
		System.out.println("Informe o cpf do cliente: ");
		cliente.setCpf(entrada.nextLine());
		
		dao = new ContaDAOLista();
		try {
			dao.salvar(new Conta(new Random().nextInt(), cliente, 100.00));
		} catch (ExcecaoElementoJaExistente | ExcecaoLimiteElementoExcedido e) {
			e.printStackTrace();
		}
	}

}
