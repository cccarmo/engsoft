package br.com.caelum.vraptor.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.blank.Pedido;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PedidoDao {
	private final Session session;

	public PedidoDao(Session session) {
		this.session = session;
	}

	public void salva2(Long id, String nome, int quant, double valor) {
		Transaction tx = session.beginTransaction();
		Pedido pedido = carrega(id);
		pedido.AdicionaItem(nome, quant, valor);
	    this.session.update(pedido);
		tx.commit();
	}
	
	public void salva(final Pedido pedido) {
		Transaction tx = session.beginTransaction();
			session.save(pedido);
		tx.commit();
	}
	
	public Pedido carrega(Long id) {
	    return (Pedido) this.session.load(Pedido.class, id);
	}
	
	public void remove(Pedido pedido) {
	    Transaction tx = session.beginTransaction();
	    this.session.delete(pedido);
	    tx.commit();
	}
	
	
	public List<Pedido> listaTudo() {
		return this.session.createCriteria(Pedido.class).list();
	}
	

}
