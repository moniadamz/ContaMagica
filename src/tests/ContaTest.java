package tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import common.Categorias;
import common.Conta;

class ContaTest {
	
	Conta conta;
	
	@BeforeEach
	public void before() {
		conta = new Conta("Gabriel");
	}
	
	@Test
	public void getNomeCliente() {
		assertEquals("Gabriel", conta.getNomeCliente());
	}

	@Test
	public void getStatusSilver() {
		conta.deposito(5000);
		assertEquals(Categorias.SILVER, conta.getStatus());
	}

	@Test
	public void getStatusGold() {
		conta.deposito(50000);
		assertEquals(Categorias.GOLD, conta.getStatus());
	}
	
	@Test
	public void getStatusGold1() {
		conta.deposito(50001.00);
		assertEquals(Categorias.GOLD, conta.getStatus());
	}

	@Test
	public void getStatusGold2() {
		conta.deposito(199999.99);
		assertEquals(Categorias.GOLD, conta.getStatus());
	}
	
	@Test
	public void getSaldo() {
		conta.deposito(2500.00); 
		assertEquals(BigDecimal.valueOf(2500), conta.getSaldo());
	}
	
	@Test
	public void getStatusPlatinum() {
		conta.deposito(200000.00);
		assertEquals(Categorias.PLATINUM, conta.getStatus());
	}

	@Test
	public void getStatusPlatinum1() {
		conta.deposito(200001.00);
		assertEquals(Categorias.PLATINUM, conta.getStatus());
	}

	@Test
	public void depositoNegativo() {
		assertEquals("Valor inválido.", conta.deposito(-1));
	}

	@Test
	public void depositoPositivo() {
		assertEquals("Depósito Efetuado.", conta.deposito(1));
	}

	@Test
	public void realizaRetiradaValorValido() {
		conta.deposito(200000.00);
		assertEquals("Retirada Efetuada.", conta.retirada(120000.00));

	}
	
	@Test
	public void realizaRetiradaValorInvalido() {
		conta.deposito(200000.00);
		assertEquals("Valor inválido para retirada.", conta.retirada(500000000));

	}
	
	@Test
	public void atualizaValorParaGold() {
		conta.deposito(200000.00);
		conta.retirada(150000);
		assertEquals(Categorias.GOLD, conta.getStatus());
	}
	
	@Test
	public void atualizaValorParaSilver() {
		conta.deposito(50000);
		conta.retirada(40000);
		assertEquals(Categorias.SILVER, conta.getStatus());
	}
}
