package com.gustavonascimento.projetoSpring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavonascimento.projetoSpring.entities.Usuario;
import com.gustavonascimento.projetoSpring.services.ServicosUsuario;

@RestController 
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	@Autowired
	private ServicosUsuario servicosUsuario;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll()
	{
		List<Usuario> usuarios=servicosUsuario.findAll();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping(value= 	"/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id)
	{
		Usuario obj=servicosUsuario.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj)
	{
		obj=servicosUsuario.inserir(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
