package com.gustavonascimento.projetoSpring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.projetoSpring.entities.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long>
{
	
}
