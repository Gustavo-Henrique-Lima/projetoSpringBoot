package com.gustavonascimento.projetoSpring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gustavonascimento.projetoSpring.entities.Produto;

public interface RepositorioProduto extends JpaRepository<Produto,Long>
{
	@Query(value="select product from Produto product where product.nome like %?1%")
	List<Produto> findByName(String nome);
}
