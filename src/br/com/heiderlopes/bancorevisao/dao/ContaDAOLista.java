package br.com.heiderlopes.bancorevisao.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.heiderlopes.bancorevisao.excecao.ExcecaoElementoInexistente;
import br.com.heiderlopes.bancorevisao.excecao.ExcecaoElementoJaExistente;
import br.com.heiderlopes.bancorevisao.excecao.ExcecaoLimiteElementoExcedido;
import br.com.heiderlopes.bancorevisao.model.Conta;

public class ContaDAOLista implements ContaDAO {

	public static int LIMITE_CONTAS = 50;
	public static List<Conta> contas = new ArrayList<>();

	@Override
	public void salvar(Conta conta) throws ExcecaoElementoJaExistente, ExcecaoLimiteElementoExcedido {

		if (contas.contains(conta)) {
			throw new ExcecaoElementoJaExistente("Cliente ja cadastrado.");
		} else {
			if (contas.size() < LIMITE_CONTAS) {
				contas.add(conta);
			} else {
				throw new ExcecaoLimiteElementoExcedido("Limite de contas atingido");
			}
		}
	}

	@Override
	public void deletar(int numeroConta) throws ExcecaoElementoInexistente{
		
		Conta contaEncontrada = null;
		
		for(Conta conta : contas) {
			if(numeroConta == conta.getNumero()) {
				contaEncontrada = conta;
			}
		}
		
		if(!contas.remove(contaEncontrada)) {
			throw new ExcecaoElementoInexistente("Conta nao cadastrada");
		}
	}

	@Override
	public List<Conta> buscarTodos() {
		return contas;
	}

	@Override
	public Conta buscarPor(int numeroConta) throws ExcecaoElementoInexistente {
		Conta contaEncontrada = null;

		for (Conta conta : contas) {
			if (conta.getNumero() == numeroConta)
				contaEncontrada = conta;
		}

		if (contaEncontrada == null) {
			throw new ExcecaoElementoInexistente("Conta nao encontrada");
		} else {
			return contaEncontrada;
		}
	}
}
