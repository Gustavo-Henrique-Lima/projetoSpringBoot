package com.gustavonascimento.projetoSpring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	public Pedido()
	{
	}

	public Pedido(Long id, Instant hora, Usuario cliente) 
	{
		super();
		this.id = id;
		this.hora = hora;
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
