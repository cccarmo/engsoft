package br.com.caelum.vraptor.testes;

import org.junit.Test;

import br.com.caelum.vraptor.blank.Pedido;

import junit.framework.Assert;

public class calculaValorTotalTeste {

	@Test
	public void ListaVazia() {
		Pedido pedido = new Pedido();
		Assert.assertEquals(0.0, pedido.CalculaValorTotal());
	}

	@Test
	public void Listacom1e1() {
		Pedido pedido = new Pedido();
		pedido.AdicionaItem("teste", 1, 2);
		Assert.assertEquals(2.0, pedido.CalculaValorTotal());
	}

	@Test
	public void Listacom1e4() {
		Pedido pedido = new Pedido();
		pedido.AdicionaItem("teste", 4, 6);
		Assert.assertEquals(24.0, pedido.CalculaValorTotal());
	}

	@Test
	public void Listacom2e1() {
		Pedido pedido = new Pedido();
		pedido.AdicionaItem("teste", 1, 6);
		pedido.AdicionaItem("teste2", 1, 6);
		Assert.assertEquals(12.0, pedido.CalculaValorTotal());
	}

	@Test
	public void Listacom2e3() {
		Pedido pedido = new Pedido();
		pedido.AdicionaItem("teste", 3, 6);
		pedido.AdicionaItem("teste2", 3, 6);
		Assert.assertEquals(36.0, pedido.CalculaValorTotal());
	}

}
