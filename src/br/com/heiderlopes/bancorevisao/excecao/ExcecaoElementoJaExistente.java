package br.com.heiderlopes.bancorevisao.excecao;

public class ExcecaoElementoJaExistente extends Exception{

	public ExcecaoElementoJaExistente(String mensagem) {
		super(mensagem);
	}
}