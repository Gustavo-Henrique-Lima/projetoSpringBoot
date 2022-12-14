package com.gustavonascimento.projetoSpring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gustavonascimento.projetoSpring.entities.enums.StatusDoPedido;

@Entity
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant hora;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Usuario cliente;
	
	private Integer status;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens=new HashSet<>();
	
	@OneToOne(mappedBy = "pedido",cascade=CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido()
	{
	}

	public Pedido(Long id, Instant hora, StatusDoPedido status,Usuario cliente) 
	{
		super();
		this.id = id;
		this.hora = hora;
		setStatus(status);
		this.cliente = cliente;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Instant getHora() 
	{
		return hora;
	}

	public void setHora(Instant hora) 
	{
		this.hora = hora;
	}

	public Usuario getCliente() 
	{
		return cliente;
	}

	public void setCliente(Usuario cliente) 
	{
		this.cliente = cliente;
	}
	
	public StatusDoPedido getStatus() 
	{
		return StatusDoPedido.pegaValorETransformaEmStatus(status);
	}

	public void setStatus(StatusDoPedido status) 
	{
		if(status !=null)
		{
			this.status = status.getCode();
		}
	}
	public Set<ItemPedido> getPedidos()
	{
		return itens;
	}
	
	public Pagamento getPagamento() 
	{
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) 
	{
		this.pagamento = pagamento;
	}

	public Double getTotalPedido()
	{
		double sum=0.0;
		for(ItemPedido x : itens)
		{
			sum+=x.getSubTotal();
		}
		return sum;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}
