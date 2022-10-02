package com.gustavonascimento.projetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.projetoSpring.entities.Pedido;
import com.gustavonascimento.projetoSpring.services.ServicosPedido;

@RestController 
@RequestMapping(value="/pedidos")
public class PedidoResource {
	@Autowired
	private ServicosPedido servicosPedido;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll()
	{
		List<Pedido> pedidos=servicosPedido.findAll();
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value= 	"/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id)
	{
		Pedido obj=servicosPedido.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
