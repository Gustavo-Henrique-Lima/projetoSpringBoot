package com.gustavonascimento.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.projetoSpring.entities.Categoria;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioCategoria;

@Service
public class ServicosCategoria {
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	public List<Categoria> findAll()
	{
		return repositorioCategoria.findAll();
	}
	
	public Categoria findById(Long id)
	{
		Optional<Categoria>obj=repositorioCategoria.findById(id);
		return obj.get();
	}
}
