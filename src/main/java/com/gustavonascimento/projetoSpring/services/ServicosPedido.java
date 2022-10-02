package com.gustavonascimento.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.projetoSpring.entities.Pedido;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioPedido;

@Service
public class ServicosPedido {
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	public List<Pedido> findAll()
	{
		return repositorioPedido.findAll();
	}
	
	public Pedido findById(Long id)
	{
		Optional<Pedido>obj=repositorioPedido.findById(id);
		return obj.get();
	}
}
