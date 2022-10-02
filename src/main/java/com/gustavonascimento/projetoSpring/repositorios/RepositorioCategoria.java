package com.gustavonascimento.projetoSpring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.projetoSpring.entities.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria,Long>
{
	
}
