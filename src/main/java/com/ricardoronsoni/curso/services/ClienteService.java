package com.ricardoronsoni.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardoronsoni.curso.domain.Cliente;
import com.ricardoronsoni.curso.repositories.ClienteRepository;
import com.ricardoronsoni.curso.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	// o autowired instacia de forma automatica uma dependencia
	// é preciso vincular um service ao seu repository
	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
