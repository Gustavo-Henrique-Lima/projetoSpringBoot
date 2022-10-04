package com.gustavonascimento.projetoSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gustavonascimento.projetoSpring.entities.Categoria;
import com.gustavonascimento.projetoSpring.entities.ItemPedido;
import com.gustavonascimento.projetoSpring.entities.Pedido;
import com.gustavonascimento.projetoSpring.entities.Produto;
import com.gustavonascimento.projetoSpring.entities.Usuario;
import com.gustavonascimento.projetoSpring.entities.enums.StatusDoPedido;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioCategoria;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioItemPedido;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioPedido;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioProduto;
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
	
	@Autowired
	private RepositorioProduto produtoRepositorio;
	
	@Autowired
	private RepositorioItemPedido itemPedidoRepositorio;
	
	
	@Override
	public void run(String... args) throws Exception 
	{
		Categoria cat1 = new Categoria(null, "Eletronicos"); 
		Categoria cat2 = new Categoria(null, "Livros"); 
		Categoria cat3 = new Categoria(null, "Computadores"); 

		Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		produtoRepositorio.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));
		categoriaRepositorio.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		pr1.getCategorias().add(cat2);
		pr2.getCategorias().add(cat1);
		pr2.getCategorias().add(cat3);
		pr3.getCategorias().add(cat3);
		pr4.getCategorias().add(cat3);
		pr5.getCategorias().add(cat2);
		
		produtoRepositorio.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));
		
		Usuario u1=new Usuario(null, "Gustavo","gustavo@gmail.com", "8199", "123");
		Usuario u2=new Usuario(null, "Guilherme", "guilherme@gmail.com", "81985", "321");
		Pedido p1= new Pedido(null, Instant.parse("2022-10-02T11:45:08Z"),StatusDoPedido.AGUARDANDO_PAGAMENTO ,u1);
		Pedido p2= new Pedido(null, Instant.parse("2022-10-01T11:30:45Z"), StatusDoPedido.ENVIADO,u2);
		Pedido p3= new Pedido(null, Instant.parse("2022-09-28T10:30:15Z"), StatusDoPedido.PAGO,u1);
		
		usuarioRepositorio.saveAll(Arrays.asList(u1,u2));
		pedidoRepositorio.saveAll(Arrays.asList(p1,p2,p3));
		
		ItemPedido oi1 = new ItemPedido(p1, pr1, 2, pr1.getPreco()); 
		ItemPedido oi2 = new ItemPedido(p1, pr3, 1, pr3.getPreco()); 
		ItemPedido oi3 = new ItemPedido(p2, pr3, 2, pr3.getPreco()); 
		ItemPedido oi4 = new ItemPedido(p3, pr5, 2, pr5.getPreco()); 

		itemPedidoRepositorio.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	}
}
