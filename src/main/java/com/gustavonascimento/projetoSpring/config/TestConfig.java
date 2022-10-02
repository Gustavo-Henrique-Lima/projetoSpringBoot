package com.gustavonascimento.projetoSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gustavonascimento.projetoSpring.entities.Pedido;
import com.gustavonascimento.projetoSpring.entities.Usuario;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioPedido;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private RepositorioUsuario usuarioRepositorio;
	@Autowired
	private RepositorioPedido pedidoRepositorio;
	@Override
	public void run(String... args) throws Exception 
	{
		Usuario u1=new Usuario(null, "Gustavo","gustavo@gmail.com", "8199", "123");
		Usuario u2=new Usuario(null, "Guilherme", "guilherme@gmail.com", "81985", "321");
		Pedido p1= new Pedido(null, Instant.parse("2022-10-02T11:45:08Z"), u1);
		Pedido p2= new Pedido(null, Instant.parse("2022-10-01T11:30:45Z"), u2);
		Pedido p3= new Pedido(null, Instant.parse("2022-09-28T10:30:15Z"), u1);
		usuarioRepositorio.saveAll(Arrays.asList(u1,u2));
		pedidoRepositorio.saveAll(Arrays.asList(p1,p2,p3));
	}
	
}
