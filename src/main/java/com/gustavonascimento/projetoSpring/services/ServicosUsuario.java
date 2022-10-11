package com.gustavonascimento.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gustavonascimento.projetoSpring.entities.Usuario;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioUsuario;
import com.gustavonascimento.projetoSpring.services.exceptions.DatabaseException;
import com.gustavonascimento.projetoSpring.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(()->new ResourceNotFoundException(id));
	}
	
	public Usuario inserir(Usuario obj)
	{
		return repositorioUsuario.save(obj);
	}
	
	public void deletar(Long id)
	{
		try
		{
			repositorioUsuario.deleteById(id);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario atualizar(Long id,Usuario obj)
	{
		try
		{
			Usuario entity =repositorioUsuario.getReferenceById(id);
			atualizarDados(entity,obj);
			return repositorioUsuario.save(entity);
		}
		catch(EntityNotFoundException e)
		{
			throw new ResourceNotFoundException(id);
		}
	}

	private void atualizarDados(Usuario entity, Usuario obj) 
	{
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setFone(obj.getFone());
	}
}
