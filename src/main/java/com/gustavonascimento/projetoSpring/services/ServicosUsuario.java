package com.gustavonascimento.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.projetoSpring.entities.Usuario;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioUsuario;

@Service
public class ServicosUsuario {
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public List<Usuario> findAll()
	{
		return repositorioUsuario.findAll();
	}
	
	public Usuario findById(Long id)
	{
		Optional<Usuario>obj=repositorioUsuario.findById(id);
		return obj.get();
	}
}
