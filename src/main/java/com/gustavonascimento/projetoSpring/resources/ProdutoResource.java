package com.gustavonascimento.projetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.projetoSpring.entities.Produto;
import com.gustavonascimento.projetoSpring.services.ServicosProduto;

@RestController 
@RequestMapping(value="/produtos")
public class ProdutoResource {
	@Autowired
	private ServicosProduto servicosProduto;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll()
	{
		List<Produto> produtos=servicosProduto.findAll();
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping(value= 	"/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id)
	{
		Produto obj=servicosProduto.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
