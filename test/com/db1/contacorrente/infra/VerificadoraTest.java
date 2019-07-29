package com.db1.contacorrente.infra;

import org.junit.Assert;
import org.junit.Test;

public class VerificadoraTest {
	//Ao testar uma exceção, utiliza o comando Try Catch para manipulação
	
	@Test		//Validando agência, numero e cliente
	public void deveRetornarExceptionQuandoStringForNula() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida(null, "Valor não pode ser nulo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser nulo", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoStringForVazia() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida(" ", "Valor não pode ser vazio");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser vazio", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoStringForValida() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida("DB1 Start", "Valor válido");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
	}
	
	@Test		//Validando valor
	public void deveRetornarExceptionQuandoValorForNulo() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(null, "Valor não pode ser nulo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser nulo", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorForInvalido() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(-0.1, "Valor não pode ser negativo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser negativo", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorForZero() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(0.0, "Valor não pode ser zero");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser zero", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorForValido() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(100.0, "Valor válido"); //Não deve retornar pois o valor é válido
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem); //Retornará nada, pois não passou pelo if.
	}
	
	@Test		//Validando saldo
	public void deveRetornarExceptionQuandoSaldoForNulo() {
		String mensagem = null;
		try {
			Verificadora.saldoMaiorQueZero(null, "Saldo não pode ser nulo");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Saldo não pode ser nulo", mensagem);
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
			Verificadora.saldoMaiorQueZero(0.0, "Não possui saldo disponível");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Não possui saldo disponível", mensagem);
	}
	
	@Test
	public void naoDeveRetornarExceptionQuandoSaldoForValido() { 
		String mensagem = null;
		try {
			Verificadora.saldoMaiorQueZero(100.0, "Saldo disponível");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem); 
	}
	
	@Test		//Validando se o valor é maior que o saldo
	public void deveRetornarExceptionQuandoValorForMaiorQueSaldo() {
		String mensagem = null;
		try {
			Verificadora.valorForMaiorQueSaldo(100.0, 101.0, "Valor a ser sacado é maior que o saldo disponível");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser sacado é maior que o saldo disponível", mensagem);
	}
}
