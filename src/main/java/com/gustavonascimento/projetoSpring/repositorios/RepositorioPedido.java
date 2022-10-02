package com.gustavonascimento.projetoSpring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.projetoSpring.entities.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido,Long>
{
	
}
