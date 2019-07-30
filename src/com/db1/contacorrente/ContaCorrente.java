package com.db1.contacorrente;

import java.util.ArrayList;
import java.util.List;

import com.db1.contacorrente.infra.Verificadora;

//COMPORTAMENTOS
//Depositar
//Sacar
//Criar conta

//ESTADOS
//Saldo

public class ContaCorrente {
	
	private String agencia;
	private String numero;
	private String cliente;
	private Double saldo;
	private List<String> historico;
	
	public ContaCorrente(String agencia, String numero, String cliente) { //Construtor com validações - novo construtor torna o padrão da classe
		
		Verificadora.verificaStringValida(agencia, "Deve ser informada uma agência válida");
		Verificadora.verificaStringValida(numero, "Deve ser informado um número de conta válido");
		Verificadora.verificaStringValida(cliente, "Deve ser informado um cliente válido");	
		
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
		this.historico = new ArrayList<>();
	}
	
	public void depositar (Double valor) {
		Verificadora.valorMaiorQueZero(valor, "Valor a ser depositado deve ser maior que zero");
		this.saldo += valor;
		this.historico.add("Depositado: R$ " + saldo);
	}
	
	public void sacar (Double valor) {
		Verificadora.saldoMaiorQueZero(saldo, "Não possui saldo disponível na conta"); 
		Verificadora.valorMaiorQueZero(valor, "Valor a ser sacado deve ser maior que zero");
		this.saldo -= valor;
		this.historico.add("Sacado: R$ " + valor + " - Saldo atual: R$ " + saldo);
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public String getNumero() {
		return numero;
	}
		
	public String getCliente() {
		return cliente;
	}
		
	public Double getSaldo() {
		return saldo;
	}
		
	public List<String> getHistorico() {
		return historico;
	}
	
}
