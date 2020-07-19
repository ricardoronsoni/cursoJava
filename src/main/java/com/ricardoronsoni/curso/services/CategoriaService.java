package com.ricardoronsoni.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardoronsoni.curso.domain.Categoria;
import com.ricardoronsoni.curso.repositories.CategoriaRepository;


@Service
public class CategoriaService {
	
	//o autowired instacia de forma automatica uma dependencia
	//é preciso vincular um service ao seu repository
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		}
	
}
