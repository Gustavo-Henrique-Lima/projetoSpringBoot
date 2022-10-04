package com.gustavonascimento.projetoSpring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.projetoSpring.entities.ItemPedido;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido,Long>
{
	
}
