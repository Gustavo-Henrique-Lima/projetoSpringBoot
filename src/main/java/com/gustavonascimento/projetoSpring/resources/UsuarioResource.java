package com.gustavonascimento.projetoSpring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.projetoSpring.entities.Usuario;

@RestController 
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	@GetMapping
	public ResponseEntity<Usuario> findAll()
	{
		Usuario u=new Usuario(1L, "Pedro", "pedro@gmail.com", "8199", "123");
		return ResponseEntity.ok().body(u);
	}
}
