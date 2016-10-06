package br.com.heiderlopes.bancorevisao.dao;

import java.util.List;

import br.com.heiderlopes.bancorevisao.model.Conta;

public interface ContaDAO {
	
	public void salvar(Conta conta);
	public void deletar(int numeroConta);
	public List<Conta> buscarTodos();
	public Conta buscarPor(int numeroConta);

}
