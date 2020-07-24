package com.ricardoronsoni.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardoronsoni.curso.domain.Pedido;
import com.ricardoronsoni.curso.repositories.PedidoRepository;
import com.ricardoronsoni.curso.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	// o autowired instacia de forma automatica uma dependencia
	// é preciso vincular um service ao seu repository
	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
