package br.com.heiderlopes.bancorevisao.dao;

import java.util.List;

import br.com.heiderlopes.bancorevisao.excecao.ExcecaoElementoInexistente;
import br.com.heiderlopes.bancorevisao.excecao.ExcecaoElementoJaExistente;
import br.com.heiderlopes.bancorevisao.excecao.ExcecaoLimiteElementoExcedido;
import br.com.heiderlopes.bancorevisao.model.Conta;

public interface ContaDAO {
	
	public void salvar(Conta conta) throws ExcecaoElementoJaExistente, ExcecaoLimiteElementoExcedido ;
	public void deletar(int numeroConta) throws ExcecaoElementoInexistente;
	public List<Conta> buscarTodos();
	public Conta buscarPor(int numeroConta) throws ExcecaoElementoInexistente;

}
