package com.gustavonascimento.projetoSpring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gustavonascimento.projetoSpring.entities.Usuario;
import com.gustavonascimento.projetoSpring.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private RepositorioUsuario usuarioRepositorio;

	@Override
	public void run(String... args) throws Exception 
	{
		Usuario u1=new Usuario(null, "Gustavo","gustavo@gmail.com", "8199", "123");
		Usuario u2=new Usuario(null, "Guilherme", "guilherme@gmail.com", "81985", "321");
		usuarioRepositorio.saveAll(Arrays.asList(u1,u2));
	}
	
}
