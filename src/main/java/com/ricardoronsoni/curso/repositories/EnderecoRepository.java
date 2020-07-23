package com.ricardoronsoni.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardoronsoni.curso.domain.Endereco;

//o integer do JpaRrepository é pq o Id da tebela categoria é integer
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
}