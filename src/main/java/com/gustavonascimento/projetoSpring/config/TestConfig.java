package com.gustavonascimento.projetoSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gustavonascimento.projetoSpring.entities.Categoria;
import com.gustavonascimento.projetoSpring.entities.Pedido;
import com.gustavonascimento.projetoSpring.entities.Usuario;
import com.gustavonascimento.projetoSpring.entities.enums.StatusDoPedido;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioCategoria;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioPedido;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private RepositorioUsuario usuarioRepositorio;
	@Autowired
	private RepositorioPedido pedidoRepositorio;
	@Autowired
	private RepositorioCategoria categoriaRepositorio;
	@Override
	public void run(String... args) throws Exception 
	{
		Categoria cat1 = new Categoria(null, "Eletronicos"); 
		Categoria cat2 = new Categoria(null, "Livros"); 
		Categoria cat3 = new Categoria(null, "Computadores"); 

		categoriaRepositorio.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Usuario u1=new Usuario(null, "Gustavo","gustavo@gmail.com", "8199", "123");
		Usuario u2=new Usuario(null, "Guilherme", "guilherme@gmail.com", "81985", "321");
		Pedido p1= new Pedido(null, Instant.parse("2022-10-02T11:45:08Z"),StatusDoPedido.AGUARDANDO_PAGAMENTO ,u1);
		Pedido p2= new Pedido(null, Instant.parse("2022-10-01T11:30:45Z"), StatusDoPedido.ENVIADO,u2);
		Pedido p3= new Pedido(null, Instant.parse("2022-09-28T10:30:15Z"), StatusDoPedido.PAGO,u1);
		usuarioRepositorio.saveAll(Arrays.asList(u1,u2));
		pedidoRepositorio.saveAll(Arrays.asList(p1,p2,p3));
	}
}
