package com.gustavonascimento.projetoSpring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.projetoSpring.entities.Produto;

public interface RepositorioProduto extends JpaRepository<Produto,Long>
{
	
}
