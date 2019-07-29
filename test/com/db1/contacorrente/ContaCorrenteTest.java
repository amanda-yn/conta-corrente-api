package com.db1.contacorrente;

	import org.junit.Assert;
	import org.junit.Test;

public class ContaCorrenteTest {		
	//Teste de valida��o
	@Test			//Valida��o do m�todo ContaCorrente			
	public void deveRetornarErroQuandoInformadoAgenciaInvalida() {
		String mensagem = null;
		try {
			ContaCorrente contaCorrente = new ContaCorrente(null, "00001234", "Maikon Cunha");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informada uma ag�ncia v�lida", mensagem);
	}	
		
	@Test
	public void deveRetornarErroQuandoInformadoNumeroInvalido() {
		String mensagem = null;
		try {
			ContaCorrente contaCorrente = new ContaCorrente("00465", null, "Maikon Cunha");
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informado um n�mero de conta v�lido", mensagem);
	}
		
	@Test
	public void deveRetornarErroQuandoInformadoClienteInvalido() {
		String mensagem = null;
		try {
			ContaCorrente contaCorrente = new ContaCorrente("00465", "00001234", null);
		} catch (RuntimeException e ) {
			mensagem = e.getMessage();
		}
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informado um cliente v�lido", mensagem);
	}
		
	@Test
	public void deveCriarContaCorrenteComValoresValidos() {
		ContaCorrente contacorrente = new ContaCorrente("00465","00001234","Maikon Cunha");
		Assert.assertEquals("00465", contacorrente.getAgencia());
		Assert.assertEquals("00001234", contacorrente.getNumero());
		Assert.assertEquals("Maikon Cunha", contacorrente.getCliente());
		Assert.assertEquals(0.0, contacorrente.getSaldo(), 0.00001);
		Assert.assertEquals(0, contacorrente.getHistorico().size());

	}
		
	@Test			//Valida��o do m�todo Depositar
	public void deveRetornarExcecaoQuandoValorDepositadoForInvalido() {
		ContaCorrente contaCorrente = new ContaCorrente("0465",  "000099999999",  "Cliente Nome");
		String mensagem = null;
		try {
			contaCorrente.depositar(-0.01);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
		
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoForZero() {
		ContaCorrente contaCorrente = new ContaCorrente("0465",  "000099999999",  "Cliente Nome");
		String mensagem = null;
		try {
			contaCorrente.depositar(0.0);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
		
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoForNull() {
		ContaCorrente contaCorrente = new ContaCorrente("0465",  "000099999999",  "Cliente Nome");
		String mensagem = null;
		try {
			contaCorrente.depositar(null);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 000.1);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
		
	@Test
	public void deveDepositarValor() {
		ContaCorrente contaCorrente = new ContaCorrente("0465", "000099999999", "Cliente Nome");
		contaCorrente.depositar(100.0);
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 000.1);
		Assert.assertEquals("Depositado: R$ 100.0", contaCorrente.getHistorico().get(0));
	}
	
	@Test			//Valida��o do m�todo Sacar
	public void deveRetornarExcecaoQuandoValorSacadoForInvalido() { 
		ContaCorrente contaCorrente = new ContaCorrente("0465", "000099999999", "Cliente Nome");
		String mensagem = null;
		try {
			contaCorrente.depositar(100.0);
			contaCorrente.sacar(-0.01);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 000.1);
		Assert.assertEquals(1, contaCorrente.getHistorico().size());
	}
	
	@Test 
	public void deveRetornarExcecaoQuandoValorSacadoForZero() { 
		ContaCorrente contaCorrente = new ContaCorrente("0465", "000099999999", "Cliente Nome");
		String mensagem = null;
		try {
			contaCorrente.depositar(100.0);
			contaCorrente.sacar(0.0);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 000.1);
		Assert.assertEquals(1, contaCorrente.getHistorico().size());
	}
	
	@Test 
	public void deveRetornarExcecaoQuandoValorSacadoForNull() { 
		ContaCorrente contaCorrente = new ContaCorrente("0465", "000099999999", "Cliente");
		String mensagem = null;
		try {
			contaCorrente.depositar(100.0);
			contaCorrente.sacar(null);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 000.1);
		Assert.assertEquals(1, contaCorrente.getHistorico().size());
	}
	
	@Test 
	public void deveRetornarExcecaoQuandoValorSacadoForMaiorQueSaldo() { 
		ContaCorrente contaCorrente = new ContaCorrente("0465", "000099999999", "Cliente");
		String mensagem = null;
		try {
			contaCorrente.depositar(100.0);
			contaCorrente.sacar(101.0);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Saldo Insuficiente: valor a ser sacado � maior que o saldo dispon�vel", mensagem);
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 000.1);
		Assert.assertEquals(1, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveSacarValor() {
		ContaCorrente contaCorrente = new ContaCorrente("0465", "000099999999", "Cliente Nome");
		contaCorrente.depositar(100.0);
		contaCorrente.sacar(100.0);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals("Sacado: R$ 100.0 - Saldo atual: R$ 0.0", contaCorrente.getHistorico().get(1));
	}
}
