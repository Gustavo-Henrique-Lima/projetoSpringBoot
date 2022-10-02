package com.gustavonascimento.projetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.projetoSpring.entities.Categoria;
import com.gustavonascimento.projetoSpring.services.ServicosCategoria;

@RestController 
@RequestMapping(value="/categorias")
public class CategoriaResource {
	@Autowired
	private ServicosCategoria servicosCategoria;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll()
	{
		List<Categoria> categorias=servicosCategoria.findAll();
		return ResponseEntity.ok().body(categorias);
	}
	
	@GetMapping(value= 	"/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id)
	{
		Categoria obj=servicosCategoria.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
