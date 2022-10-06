package com.gustavonascimento.projetoSpring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant time;
	
	@OneToOne
	@MapsId
	private Pedido pedido;
	
	public Pagamento()
	{
	}

	public Pagamento(Long id, Instant time, Pedido pedido) 
	{
		super();
		this.id = id;
		this.time = time;
		this.pedido = pedido;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Instant getTime() 
	{
		return time;
	}

	public void setTime(Instant time) 
	{
		this.time = time;
	}

	public Pedido getPedido() 
	{
		return pedido;
	}

	public void setPedido(Pedido pedido) 
	{
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
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
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
}
