package com.gustavonascimento.projetoSpring.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustavonascimento.projetoSpring.entities.pk.ItemPedidoPK;

@Entity
@Table(name="Produto_Pedido")
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id=new ItemPedidoPK();
	
	private Integer qtd;
	
	private Double preco;
	
	public ItemPedido()
	{
	}

	public ItemPedido(Pedido pedido,Produto produto,Integer qtd, Double preco) 
	{
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.qtd = qtd;
		this.preco = preco;
	}

	public Integer getQtd() 
	{
		return qtd;
	}

	public void setQtd(Integer qtd) 
	{
		this.qtd = qtd;
	}

	public Double getPreco() 
	{
		return preco;
	}

	public void setPreco(Double preco) 
	{
		this.preco = preco;
	}
	@JsonIgnore
	public Pedido getPedido()
	{
		return id.getPedido();
	}
	public void setPedido(Pedido pedido)
	{
		id.setPedido(pedido);
	}
	
	public Produto getProduto()
	{
		return id.getProduto();
	}
	public void setProduto(Produto produto)
	{
		id.setProduto(produto);
	}
	@Override
	public int hashCode() 
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
