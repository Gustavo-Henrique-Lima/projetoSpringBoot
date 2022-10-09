package com.gustavonascimento.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.projetoSpring.entities.Usuario;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioUsuario;
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
		repositorioUsuario.deleteById(id);
	}
	
	public Usuario atualizar(Long id,Usuario obj)
	{
		Usuario entity =repositorioUsuario.getReferenceById(id);
		atualizarDados(entity,obj);
		return repositorioUsuario.save(entity);
	}

	private void atualizarDados(Usuario entity, Usuario obj) 
	{
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setFone(obj.getFone());
	}
}
