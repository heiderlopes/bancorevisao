package br.com.heiderlopes.bancorevisao.model;

public class Conta {

	private int numero;
	private double saldo;
	private Cliente cliente;

	public Conta(int numero, Cliente cliente, double saldo) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public boolean equals(Object object) {
		Conta conta = (Conta)object;
		return this.cliente.equals(conta.getCliente());
	}
	
	

}
