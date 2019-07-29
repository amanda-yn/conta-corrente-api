package com.db1.contacorrente.infra;

import org.junit.Assert;
import org.junit.Test;

public class VerificadoraTest {
	//Ao testar uma exce��o, utiliza o comando Try Catch para manipula��o
	
	@Test		//Validando ag�ncia, numero e cliente
	public void deveRetornarExceptionQuandoStringForNula() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida(null, "Valor n�o pode ser nulo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor n�o pode ser nulo", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoStringForVazia() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida(" ", "Valor n�o pode ser vazio");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor n�o pode ser vazio", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoStringForValida() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida("DB1 Start", "Valor v�lido");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
	}
	
	@Test		//Validando valor
	public void deveRetornarExceptionQuandoValorForNulo() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(null, "Valor n�o pode ser nulo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor n�o pode ser nulo", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorForInvalido() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(-0.1, "Valor n�o pode ser negativo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor n�o pode ser negativo", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorForZero() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(0.0, "Valor n�o pode ser zero");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor n�o pode ser zero", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorForValido() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(100.0, "Valor v�lido"); //N�o deve retornar pois o valor � v�lido
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem); //Retornar� nada, pois n�o passou pelo if.
	}
	
	@Test		//Validando saldo
	public void deveRetornarExceptionQuandoSaldoForNulo() {
		String mensagem = null;
		try {
			Verificadora.saldoMaiorQueZero(null, "Saldo n�o pode ser nulo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Saldo n�o pode ser nulo", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoSaldoForInvalido() {
		String mensagem = null;
		try {
			Verificadora.saldoMaiorQueZero(-0.1, "Saldo negativo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Saldo negativo", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoSaldoForZero() {
		String mensagem = null;
		try {
			Verificadora.saldoMaiorQueZero(0.0, "N�o possui saldo dispon�vel");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("N�o possui saldo dispon�vel", mensagem);
	}
	
	@Test
	public void naoDeveRetornarExceptionQuandoSaldoForValido() { 
		String mensagem = null;
		try {
			Verificadora.saldoMaiorQueZero(100.0, "Saldo dispon�vel");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem); 
	}
	
	@Test		//Validando se o valor � maior que o saldo
	public void deveRetornarExceptionQuandoValorForMaiorQueSaldo() {
		String mensagem = null;
		try {
			Verificadora.valorForMaiorQueSaldo(100.0, 101.0, "Valor a ser sacado � maior que o saldo dispon�vel");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser sacado � maior que o saldo dispon�vel", mensagem);
	}
}
