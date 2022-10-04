package com.gustavonascimento.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.projetoSpring.entities.Produto;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioProduto;

@Service
public class ServicosProduto {
	@Autowired
	private RepositorioProduto repositorioProduto;
	
	public List<Produto> findAll()
	{
		return repositorioProduto.findAll();
	}
	
	public Produto findById(Long id)
	{
		Optional<Produto>obj=repositorioProduto.findById(id);
		return obj.get();
	}
}
