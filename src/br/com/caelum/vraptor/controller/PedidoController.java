package br.com.caelum.vraptor.controller;

import java.util.List;


import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.blank.Pedido;
import br.com.caelum.vraptor.dao.PedidoDao;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class PedidoController {
	private final Result result;
	private final PedidoDao dao;
	private final Validator validator;
	

	public PedidoController(PedidoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	public List<Pedido> lista_pedido() {
		return dao.listaTudo();
	}
	
	public Pedido lista_item(Long id) {
		Pedido pedido = dao.carrega(id);
		return pedido;
	}
	
	public void adiciona(Pedido pedido) {
		if (pedido.getNome_cliente() == null) {
	        validator.add(new ValidationMessage(
	                "Insira um nome para cadastrar o pedido",null));
	    }
		validator.onErrorUsePageOf(PedidoController.class).formulario();
	    dao.salva(pedido);
	    result.redirectTo(this).formulario2(pedido);
	}
	
	public void adiciona_item(Long id,String nome_Produto, 
			int quantidade, double valor_unitario) {
		Pedido pedido = dao.carrega(id);
		dao.salva2(id, nome_Produto, quantidade, valor_unitario);
		result.redirectTo(this).formulario2(pedido);
		
	}
	
	public Pedido formulario2 (Pedido pedido) {
		return pedido;
	}
	
	public void remove(Long id) {
	    Pedido pedido = dao.carrega(id);
	    dao.remove(pedido);
	    result.redirectTo(this).lista_pedido();
	}
	
	public void formulario() {
		
	}
	
}
	
