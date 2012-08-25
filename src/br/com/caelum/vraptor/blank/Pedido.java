package br.com.caelum.vraptor.blank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id @GeneratedValue
	private Long id;

	private String nome_cliente;
	private String data = datadehoje();
	private double valor_total = 0;
	private int total_itens = 0;
	
	@OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL)
	public List<Item> lista = new ArrayList<Item>();
	
	public Pedido() {
	}	
	
	private String datadehoje() {
		Calendar calendario = Calendar.getInstance();
		String retorna = "dd/MM/yyyy";
		SimpleDateFormat Data = new SimpleDateFormat(retorna);
		return Data.format(calendario.getTime());
	}
	
	public double CalculaValorTotal() {
		double total = 0;
		for(Item i : lista)
			total += i.Valor_Item();
		return total;
	}
	
	public void AdicionaItem (String nome, int quant, double valor) {
		Item item = new Item();
		item.setNome(nome);
		item.setquantidade(quant);
		item.setvalor_unitario(valor);
		item.setPedido(this);
		item.setValor_total(item.Valor_Item());
		lista.add(item);
		this.valor_total = CalculaValorTotal();
		total_itens += quant;
		
	}
	
	public int getTotal_itens() {
		return total_itens;
	}
	public void setTotal_itens(int total_itens) {
		this.total_itens = total_itens;
	}
	
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}	
	
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	
	public String getNome_cliente() {
		return nome_cliente;
	}
	
	public List<Item> getLista() {
		return lista;
	}
	
	public void setLista(List<Item> lista) {
		this.lista = lista;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
