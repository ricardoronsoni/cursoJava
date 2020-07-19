package com.ricardoronsoni.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardoronsoni.curso.domain.Categoria;
import com.ricardoronsoni.curso.repositories.CategoriaRepository;


//o commandlinerunner é apenas para inserir os valores no banco antes do rodar a aplicacao
@SpringBootApplication
public class CursoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	//esse metodo é apenas para inserir os valores no banco antes do rodar a aplicacao
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		
	}

}
