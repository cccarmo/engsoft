package br.com.caelum.vraptor.blank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	private int quantidade;
	private double valor_unitario;
	private double valor_total;
	
	@ManyToOne
	private Pedido pedido;
	
	
	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public Pedido getPedido() {
		return pedido;
	}		

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public double Valor_Item() {
		return quantidade * valor_unitario;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setquantidade(int Quantidade) {
		quantidade = Quantidade;
	}
	
	public double getvalor_unitario() {
		return valor_unitario;
	}
	
	public void setvalor_unitario(double Valor_unitario) {
		valor_unitario = Valor_unitario;
	}

}
